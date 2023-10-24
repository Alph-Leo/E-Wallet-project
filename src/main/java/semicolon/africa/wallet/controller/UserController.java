package semicolon.africa.wallet.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.africa.wallet.dtos.request.RegistrationRequest;
import semicolon.africa.wallet.dtos.request.SignUpRequest;
import semicolon.africa.wallet.dtos.response.RegistrationResponse;
import semicolon.africa.wallet.dtos.response.SignUpResponse;
import semicolon.africa.wallet.service.UserService;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest request){
        SignUpResponse response = userService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
