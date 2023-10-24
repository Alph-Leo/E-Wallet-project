package semicolon.africa.wallet.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.WalletAppApplication;
import semicolon.africa.wallet.data.models.Transaction;
import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.WalletResponse;

import java.math.BigDecimal;
import java.util.List;

import static org.bson.assertions.Assertions.assertNotNull;


@SpringBootTest(classes = WalletAppApplication.class)
@Slf4j
public class WalletServiceTest {
    @Autowired
    private WalletService walletService;

    @Test
    public void testCreateWallet(){
        WalletRequest request = new WalletRequest();
        request.setBalance(BigDecimal.valueOf(1000));
        request.setTransactions(List.of(new Transaction()));


        WalletResponse savedWallet = walletService.createWallet(request);
        log.info("Newly created wallet------->{}", savedWallet);
        assertNotNull(savedWallet);
    }
}
