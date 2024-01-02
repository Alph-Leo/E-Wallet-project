package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Transaction;
import semicolon.africa.wallet.data.models.TransactionType;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.TransactionRepository;
import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.response.TransactionResponse;
import semicolon.africa.wallet.exception.WalletBaseException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class E_WalletTransactionService implements TransactionService{
    private final TransactionRepository transactionRepository;
    private final WalletService walletService;

    @Override
    public TransactionResponse transferFund(TransactionRequest transferRequest) {
        String sender = transferRequest.getSenderId();
        String receiver = transferRequest.getReceiverId();

        Wallet firstWallet = walletService.findWalletById(sender);
        Wallet secondWallet = walletService.findWalletById(receiver);


        BigDecimal senderWalletBalance = firstWallet.getBalance();
        BigDecimal receiverWalletBalance = secondWallet.getBalance();
        BigDecimal transactionAmount = transferRequest.getAmount();

        if (senderWalletBalance.compareTo(transactionAmount) >= 0 ){
            Transaction transaction = getTransaction(transferRequest, sender, receiver, transactionAmount);

            Transaction savedTransaction = transactionRepository.save(transaction);

            buildTransaction(firstWallet, secondWallet, senderWalletBalance, receiverWalletBalance, transactionAmount, savedTransaction);

            return getTransactionResponse(savedTransaction);
        } else {
            throw new WalletBaseException("Insufficient Fund");
        }

    }

    private void buildTransaction(Wallet firstWallet, Wallet secondWallet,
                                  BigDecimal senderWalletBalance, BigDecimal receiverWalletBalance,
                                  BigDecimal transactionAmount, Transaction savedTransaction) {

        firstWallet.setTransactions(List.of(savedTransaction));
        secondWallet.setTransactions(List.of(savedTransaction));
        firstWallet.setBalance(senderWalletBalance.subtract(transactionAmount));
        secondWallet.setBalance(receiverWalletBalance.add(transactionAmount));

        walletService.updateWallet(firstWallet);
        walletService.updateWallet(secondWallet);
    }

    @NotNull
    private static Transaction getTransaction(TransactionRequest transferRequest, String sender, String receiver, BigDecimal transactionAmount) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(transferRequest.getTransactionId());
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setSenderId(sender);
        transaction.setReceiverId(receiver);
        transaction.setAmount(transactionAmount);
        transaction.setTransactionDate(LocalDateTime.now());
        return transaction;
    }

    @NotNull
    private static TransactionResponse getTransactionResponse(Transaction savedTransaction) {
        TransactionResponse response = new TransactionResponse();
        response.setMessage("Transaction successful");
        response.setTransactionId(savedTransaction.getTransactionId());
        response.setTransactionType(savedTransaction.getTransactionType());
        response.setAmount(savedTransaction.getAmount());
        response.setTransactionDate(LocalDateTime.now());
        return response;
    }
}
