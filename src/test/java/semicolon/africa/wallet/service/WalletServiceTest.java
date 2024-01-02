package semicolon.africa.wallet.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.WalletAppApplication;
import semicolon.africa.wallet.data.models.Transaction;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;

import java.math.BigDecimal;
import java.util.List;

import static org.bson.assertions.Assertions.assertNotNull;


@SpringBootTest(classes = WalletAppApplication.class)
@Slf4j
public class WalletServiceTest {
    @Autowired
    private WalletService walletService;

    @Test
    public void testThatICanSignUp(){
        RegistrationRequest request = new RegistrationRequest();
        request.setUserName("SaheedDammy");
        request.setEmail("Saidex@1ymail.com");
        request.setPhoneNumber("07065506982");
        request.setPassword("lovely boy");

        RegistrationResponse savedWallet = walletService.signUp(request);
        log.info("Newly created wallet------->{}", savedWallet);
        assertNotNull(savedWallet);
    }
    @Test
    public void testThatICanLogin(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("Saidex@1ymail.com");
        loginRequest.setPassword("lovely boy");

        LoginResponse newLogin = walletService.login(loginRequest);
        log.info("new login --------->{}", newLogin);
        assertNotNull(newLogin);

    }
    @Test
    public void testThatAnotherUserCanSignUp(){
        RegistrationRequest request2 = new RegistrationRequest();
        request2.setUserName("AlphaLeo");
        request2.setEmail("Dammoh@yahoo.com");
        request2.setPhoneNumber("08169717282");
        request2.setPassword("stoneage");

        RegistrationResponse savedWallet = walletService.signUp(request2);
        log.info("Another wallet created------->{}", savedWallet);
        assertNotNull(savedWallet);
    }
    @Test
    public void testThatAnotherUserCanLogin(){
        LoginRequest loginRequest2 = new LoginRequest();
        loginRequest2.setPhoneNumber("08169717282");
        loginRequest2.setPassword("jsfhriufhlfkjd");

    }
}
