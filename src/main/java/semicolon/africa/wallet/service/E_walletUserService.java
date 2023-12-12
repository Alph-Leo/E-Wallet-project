package semicolon.africa.wallet.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Address;
import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.UserRepository;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.request.SignUpRequest;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.SignUpResponse;
import semicolon.africa.wallet.dtos.response.WalletResponse;
import semicolon.africa.wallet.exception.WalletBaseException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import static semicolon.africa.wallet.utils.AppUtils.REGISTRATION_SUCCESSFUL_MESSAGE;
import static semicolon.africa.wallet.utils.AppUtils.USER_NOT_FOUND_EXCEPTION;

@Service
@AllArgsConstructor
@Slf4j
public class E_walletUserService implements UserService{
    private final UserRepository userRepository;
    private final WalletService walletService;
    @Override
    public SignUpResponse signUp(SignUpRequest signUpRequest) {
        User user = new User();
//        String userId = user.getUserId();
        user.setUserId(signUpRequest.getUserId());
        user.setUserName(signUpRequest.getUserName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setPhoneNumber(signUpRequest.getPhoneNumber());
        WalletRequest walletRequest = new WalletRequest();
        walletRequest.setUser(user);
        walletRequest.setBalance(BigDecimal.valueOf(0.00));
        walletRequest.setTransactions(new ArrayList<>());
        walletService.createWallet(walletRequest);

//        WalletResponse userWallet = addWalletToUser(user.getUserId(), walletRequest);
//        user.setWallet(userWallet.getUser().getWallet());


        userRepository.save(user);
        SignUpResponse response = new SignUpResponse();
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
    public LoginResponse login(LoginRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String password = request.getPassword();

        return getLoginResponse(phoneNumber, password);
    }

    @NotNull
    private LoginResponse getLoginResponse(String phoneNumber, String password) {
        User user = userRepository.findUserByPhoneNumber(phoneNumber);
        if (user != null){
            if (Objects.equals(user.getPassword(), password)){
                LoginResponse response = new LoginResponse();
                response.setMessage("Welcome back !");
                log.info("---->{}", response);
                return response;
            }
            throw new WalletBaseException(USER_NOT_FOUND_EXCEPTION);
        }
        throw new WalletBaseException(USER_NOT_FOUND_EXCEPTION);
    }

    @Override
    public User findUserById(String id) {
        User foundUser = userRepository
                        .findById(id)
                        .orElseThrow(()-> new WalletBaseException(USER_NOT_FOUND_EXCEPTION));
        userRepository.save(foundUser);
        return foundUser;
    }

//    @Override
//    public WalletResponse addWalletToUser(String userId, WalletRequest walletRequest) {
//                User foundUser = userRepository
//                         .findById(userId)
//                         .orElseThrow(() -> new WalletBaseException(USER_NOT_FOUND_EXCEPTION));
//        walletRequest.setBalance(BigDecimal.valueOf(0.00));
//        walletRequest.setTransactions(new ArrayList<>());
//
//        WalletResponse savedWallet = walletService.createWallet(walletRequest);
//
//        savedWallet.setUser(foundUser);
//
//        foundUser.setWallet(savedWallet.getUser().getWallet());
//        userRepository.save(foundUser);
//
//        return savedWallet;
//    }


}
