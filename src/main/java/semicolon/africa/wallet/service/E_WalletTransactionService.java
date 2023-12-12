package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Transaction;
import semicolon.africa.wallet.data.models.TransactionType;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.TransactionRepository;
import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.request.WalletRequest;
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
        Wallet senderWallet = walletService.findByUserId(transferRequest.getSenderId());
        Wallet receiverWallet = walletService.findByUserId(transferRequest.getReceiverId());

        BigDecimal senderWalletBalance = senderWallet.getBalance();
        BigDecimal transactionAmount = transferRequest.getAmount();

        if (senderWalletBalance.compareTo(transactionAmount) >= 100 ){
            Transaction transaction = new Transaction();
            transaction.setTransactionId(transferRequest.getTransactionId());
            transaction.setTransactionType(TransactionType.TRANSFER);
            transaction.setSenderId(senderWallet.getUser().getUserId());
            transaction.setReceiverId(receiverWallet.getUser().getUserId());
            transaction.setAmount(transactionAmount);
            transaction.setTransactionDate(LocalDateTime.now());

            Transaction savedTransaction = transactionRepository.save(transaction);

            senderWallet.setBalance(senderWalletBalance.subtract(transactionAmount));
            receiverWallet.setBalance(receiverWallet.getBalance().add(transactionAmount));
            walletService.updateWallet(senderWallet);
            walletService.updateWallet(receiverWallet);

            TransactionResponse response = new TransactionResponse();
            response.setMessage("Transaction successful");
            response.setTransactionId(savedTransaction.getTransactionId());
            response.setTransactionDate(LocalDateTime.now());
            return response;


        } else {
            throw new WalletBaseException("Insufficient Fund");
        }

    }
}
