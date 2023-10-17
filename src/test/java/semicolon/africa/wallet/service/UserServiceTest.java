package semicolon.africa.wallet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatUserCanSignUp(){
        RegistrationRequest request = new RegistrationRequest();
        request.setUserName("Saheed Dammy");
        request.setEmail("saidex1@ymail.com");
        request.setPassword("comingmessiah");
        request.setPhoneNumber("08169717282");
        getAddress(request);
        request.setCard(new ArrayList<>());
        request.setWallet(new Wallet());
        request.setBankAccount(new ArrayList<>());
        request.setBankAccount(new ArrayList<>());

        RegistrationResponse newUser = userService.signUp(request);
        assertNotNull(newUser);



    }

    private static void getAddress(RegistrationRequest request) {
        request.setHouseNumber("312");
        request.setStreet("Havey road street");
        request.setLocalGovernmentArea("Mainland");
        request.setState("Lagos state");
        request.setCountry("Nigeria");
    }
}
