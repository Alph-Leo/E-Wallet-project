package semicolon.africa.wallet.service;

import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.ProfileUpdateRequest;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.ProfileUpdateResponse;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;

public interface WalletService {
    RegistrationResponse signUp(RegistrationRequest registrationRequest);
    LoginResponse login(LoginRequest loginRequest);
    Wallet findWalletById(String id);
    void updateWallet(Wallet wallet);
    ProfileUpdateResponse updateProfile(ProfileUpdateRequest profileUpdateRequest, String userId);

}
