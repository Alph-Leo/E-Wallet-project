package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Address;
import semicolon.africa.wallet.data.models.BankAccount;
import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.repositories.UserRepository;
import semicolon.africa.wallet.dtos.request.AddressRequest;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.AddressResponse;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;
import semicolon.africa.wallet.exception.WalletBaseException;
import semicolon.africa.wallet.service.otpService.OtpService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static semicolon.africa.wallet.utils.AppUtils.*;

@Service
@RequiredArgsConstructor
public class E_walletUserService implements UserService{
    private final UserRepository userRepository;
    private OtpService otpService;
    @Override
    public RegistrationResponse signUp(RegistrationRequest registrationRequest) {
        User user = new User();
        user.setUserName(registrationRequest.getUserName());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());
        user.setPhoneNumber(registrationRequest.getPhoneNumber());

        Address address = getAddress(registrationRequest);
        user.setAddress(address);
        user.setWallet(registrationRequest.getWallet());
        user.setBankAccount(new ArrayList<>());
        user.setCard(new ArrayList<>());
        user.setNotification(registrationRequest.getNotification());

            User savedUser = userRepository.save(user);
            RegistrationResponse response = new RegistrationResponse();
            response.setMessage(REGISTRATION_SUCCESSFUL_MESSAGE);

            return response;

    }

    private static Address getAddress(RegistrationRequest registrationRequest) {
        Address address = new Address();
        address.setAddressId(address.getAddressId());
        address.setHouseNumber(registrationRequest.getHouseNumber());
        address.setStreet(registrationRequest.getStreet());
        address.setLocalGovernmentArea(registrationRequest.getLocalGovernmentArea());
        address.setState(registrationRequest.getState());
        address.setCountry(registrationRequest.getCountry());
        return address;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        return null;
    }
    private String generateRandomOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);
        return String.valueOf(otp);
    }

}
