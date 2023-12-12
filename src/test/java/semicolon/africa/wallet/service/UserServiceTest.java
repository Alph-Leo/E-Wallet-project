package semicolon.africa.wallet.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.request.SignUpRequest;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.SignUpResponse;
import semicolon.africa.wallet.dtos.response.WalletResponse;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Slf4j
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatUserCanSignUp(){
        SignUpRequest request = new SignUpRequest();

        request.setUserName("Saidex");
        request.setEmail("Leo_nation@yahoo.com");
        request.setPassword("lionheart");
        request.setPhoneNumber("07065506982");

        SignUpResponse newUser = userService.signUp(request);
        log.info("New User ans Wallet created ------>{}", newUser);
        assertNotNull(newUser);



    }

    @Test
    public void testThatUser2CanSignUp() {
        SignUpRequest request2 = new SignUpRequest();

        request2.setUserName("Leo");
        request2.setEmail("saidex1@ymail.com");
        request2.setPassword("foldedspace");
        request2.setPhoneNumber("08169717282");

        SignUpResponse newUser2 = userService.signUp(request2);
        log.info("New User ans Wallet created ------>{}", newUser2);
        assertNotNull(newUser2);
    }

    private static void getAddress(RegistrationRequest request2) {
        request2.setHouseNumber("312");
        request2.setStreet("Havey road street");
        request2.setLocalGovernmentArea("Mainland");
        request2.setState("Lagos state");
        request2.setCountry("Nigeria");
    }
    @Test
    public void testThatUserCanLogin(){
        LoginRequest request = new LoginRequest();

        request.setPhoneNumber("07065506982");
        request.setPassword("lionheart");

        LoginResponse response = userService.login(request);
        assertNotNull(response);

    }
//    @Test
//    public void testThatUserCanCreateWallet(){
//        String userId = "6536c2c9e225eb483deedb55";
//        WalletRequest walletRequest = new WalletRequest();
//        walletRequest.setBalance(BigDecimal.valueOf(0.00));
//        walletRequest.setTransactions(new ArrayList<>());
//
//        WalletResponse response = userService.addWalletToUser(userId, walletRequest);
//        log.info("new wallet created---->>>{}", response);
//        assertNotNull(response);
//    }
}
