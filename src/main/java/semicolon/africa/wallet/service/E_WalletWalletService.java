package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import semicolon.africa.wallet.data.models.ProfileUpdate;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.data.repositories.WalletRepository;
import semicolon.africa.wallet.dtos.request.ProfileUpdateRequest;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.ProfileUpdateResponse;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;
import semicolon.africa.wallet.exception.WalletBaseException;
import semicolon.africa.wallet.service.cloud.CloudService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Objects;

import static semicolon.africa.wallet.utils.AppUtils.*;


@Service
@RequiredArgsConstructor
@Slf4j
public class E_WalletWalletService implements WalletService{
    private final WalletRepository walletRepository;
    private final CloudService cloudService;

    @Override
    public RegistrationResponse signUp(RegistrationRequest registrationRequest) {
        String email = registrationRequest.getEmail().toLowerCase();
        String phoneNumber = registrationRequest.getPhoneNumber();

//        if (walletRepository.existByMail(email) || walletRepository.existByPhoneNumber(phoneNumber)){
//            throw new WalletBaseException("Email Or Phone Number Already Exists");
//        }
        if (validateEmail(email)) {

            Wallet wallet = new Wallet();
            wallet.setWalletId(registrationRequest.getWalletId());
            wallet.setUserName(registrationRequest.getUserName());
            wallet.setEmail(email);
            wallet.setPhoneNumber(phoneNumber);
            wallet.setPassword(registrationRequest.getPassword());
            wallet.setBalance(BigDecimal.ZERO);
            wallet.setTransactions(new ArrayList<>());

            Wallet savedWallet = walletRepository.save(wallet);

            RegistrationResponse response = new RegistrationResponse();
            response.setMessage(REGISTRATION_SUCCESSFUL_MESSAGE);

            return response;
        }throw new WalletBaseException(INVALID_EMAIL_EXCEPTION);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        String email = loginRequest.getEmail().toLowerCase();
        String phoneNumber = loginRequest.getPhoneNumber();

        Wallet walletUser = walletRepository.findUserByEmailOrPhoneNumber(email, phoneNumber);
        if (walletUser != null && Objects.equals(walletUser.getPassword(), loginRequest.getPassword())){
            String userName = walletUser.getUserName();
            LoginResponse response = new LoginResponse();
            response.setMessage(LOGIN_SUCCESSFUL_MESSAGE + BLANK_SPACE + userName);

            return response;
        }else throw new WalletBaseException(LOGIN_ERROR_MESSAGE);
    }

    @Override
    public Wallet findWalletById(String walletId) {
        Wallet foundWallet = walletRepository.findById(walletId)
                                                .orElseThrow(()-> new
                                                        WalletBaseException(USER_NOT_FOUND_EXCEPTION));
        return foundWallet;
    }

    @Override
    public void updateWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public ProfileUpdateResponse updateProfile(ProfileUpdateRequest profileUpdateRequest, String userId) {
        Wallet foundWallet = walletRepository
                                .findById(userId)
                                    .orElseThrow(() -> new WalletBaseException(USER_NOT_FOUND_EXCEPTION));

        MultipartFile imageProfile = profileUpdateRequest.getProfileImage();
        String imageUrl = cloudService.upload(imageProfile);

        ProfileUpdate profileUpdate = new ProfileUpdate();
        profileUpdate.setAddressId(profileUpdateRequest.getAddressId());
        profileUpdate.setHouseNumber(profileUpdateRequest.getHouseNumber());
        profileUpdate.setStreet(profileUpdateRequest.getStreet());
        profileUpdate.setLocalGovernmentArea(profileUpdateRequest.getLocalGovernmentArea());
        profileUpdate.setState(profileUpdateRequest.getState());
        profileUpdate.setCountry(profileUpdateRequest.getCountry());
        profileUpdate.setProfileImage(imageUrl);

        foundWallet.setProfileUpdate(profileUpdate);

        walletRepository.save(foundWallet);

        ProfileUpdateResponse response = new ProfileUpdateResponse();
        response.setMessage(UPDATE_SUCCESS_MESSAGE);


        return response;
    }


}
