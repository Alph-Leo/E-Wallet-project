package semicolon.africa.wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import semicolon.africa.wallet.service.otpService.OtpService;

@RestController
@RequestMapping("")
public class OtpController {
    private OtpService otpService;

    @PostMapping("sendOtp")
    public void sendOtp(@RequestBody String recipientNumber){
        otpService.sendOtp(recipientNumber);
    }
}
