package semicolon.africa.wallet.service.otpService;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoResponseParseException;
import com.nexmo.client.verify.VerifyClient;
import com.nexmo.client.verify.VerifyRequest;
import com.nexmo.client.verify.VerifyResponse;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static semicolon.africa.wallet.utils.AppUtils.OTP_FAILED_EXCEPTION;
import static semicolon.africa.wallet.utils.AppUtils.OTP_SUCCESS_MESSAGE;

@Service@Slf4j
public class WalletOtpService implements OtpService{

        public void sendOtp(String recipientNumber) {
        String ACCOUNT_SID = System.getenv("AC437f264a7924a4e6c16c04bcf2398243");
        String AUTH_TOKEN = System.getenv("ce28365b42ec95b1bff5f0d21c23e5ba");

        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        new PhoneNumber(recipientNumber),
                        new PhoneNumber("+2347065506982"),
                        "Ahoy! This message was sent from my Twilio phone number!")
                .create();

        System.out.println(message.getBody());
    }


}
