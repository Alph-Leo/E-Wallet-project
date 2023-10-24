package semicolon.africa.wallet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.request.SignUpRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.SignUpResponse;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
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
        assertNotNull(newUser);



    }

    private static void getAddress(RegistrationRequest request) {
        request.setHouseNumber("312");
        request.setStreet("Havey road street");
        request.setLocalGovernmentArea("Mainland");
        request.setState("Lagos state");
        request.setCountry("Nigeria");
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
//        String userId = "6532590f00d6555dbbe9bb99";
////        User user = new User();
//        WalletRequest walletRequest = new WalletRequest();
//        walletRequest.setBalance(BigDecimal.valueOf(0.00));
//        walletRequest.setTransactions(null);

//        WalletResponse response = userService.addWallet(walletRequest, userId);
//        assertNotNull(response);
//    }
}
