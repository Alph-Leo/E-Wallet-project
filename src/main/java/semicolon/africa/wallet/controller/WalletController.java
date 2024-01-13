package semicolon.africa.wallet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import semicolon.africa.wallet.dtos.request.LoginRequest;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.response.LoginResponse;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;
import semicolon.africa.wallet.service.WalletService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
@CrossOrigin("*")
public class WalletController {
    private WalletService walletService;

    @PostMapping
    public ResponseEntity<RegistrationResponse> signUp(@RequestBody RegistrationRequest request){
        RegistrationResponse response = walletService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        LoginResponse response = walletService.login(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}

