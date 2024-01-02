package semicolon.africa.wallet.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.data.models.TransactionType;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.TransactionRequest;
import semicolon.africa.wallet.dtos.response.TransactionResponse;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class TransactionServiceTest {
    @Autowired
    private TransactionService transactionService;
    private WalletService walletService;

    @Test
    public void testThatICanTransfer(){

        TransactionRequest transferRequest = new TransactionRequest();
        String sender = "659436866177a1353a70bd1a";
        String receiver = "659436a198034d5a3c4a3e11";
        transferRequest.setSenderId(sender);
        transferRequest.setReceiverId(receiver);
        transferRequest.setTransactionType(TransactionType.TRANSFER);
        transferRequest.setAmount(BigDecimal.valueOf(2500));

        TransactionResponse newTransaction = transactionService.transferFund(transferRequest);
        log.info("New Transaction ------------>{}", newTransaction);

        assertNotNull(newTransaction);
    }
}
