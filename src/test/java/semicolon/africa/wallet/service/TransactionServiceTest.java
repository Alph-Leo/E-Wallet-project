package semicolon.africa.wallet.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.data.models.TransactionType;
import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.response.TransactionResponse;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

@SpringBootTest
@Slf4j
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;

    @Test
    public void testThatICanTransfer(){
        Wallet senderWallet = new Wallet();
        senderWallet.setBalance(BigDecimal.valueOf(5000));
        senderWallet.setUser(new User());

        Wallet receiverWallet = new Wallet();
        receiverWallet.setBalance(BigDecimal.valueOf(500));
        receiverWallet.setUser(new User());

        TransactionRequest transferRequest = new TransactionRequest();
        String sender = "65789b520b3e1a310968aca9";
        String receiver = "6578a98b308a5a34639003b5";
        transferRequest.setSenderId(sender);
        transferRequest.setReceiverId(receiver);
        transferRequest.setTransactionType(TransactionType.TRANSFER);
        transferRequest.setAmount(BigDecimal.valueOf(1500));

        TransactionResponse newTransaction = transactionService.transferFund(transferRequest);

        assertNotNull(newTransaction);
    }
}
