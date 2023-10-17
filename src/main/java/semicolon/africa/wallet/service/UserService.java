package semicolon.africa.wallet.service;

import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;

public interface UserService {
    RegistrationResponse signUp(RegistrationRequest registrationRequest);
    LoginResponse login(LoginRequest loginRequest);
}
