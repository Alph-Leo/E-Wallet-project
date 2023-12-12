package semicolon.africa.wallet.service;

import semicolon.africa.wallet.data.models.User;
import semicolon.africa.wallet.data.models.Wallet;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.SignUpRequest;
import semicolon.africa.wallet.dtos.request.WalletRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.SignUpResponse;
import semicolon.africa.wallet.dtos.response.WalletResponse;

import java.math.BigDecimal;

public interface UserService {
    SignUpResponse signUp(SignUpRequest signUpRequest);
    LoginResponse login(LoginRequest request);
    User findUserById(String id);
//    WalletResponse addWalletToUser(String userId, WalletRequest walletRequest);

}
