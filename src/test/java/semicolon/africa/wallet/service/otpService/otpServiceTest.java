package semicolon.africa.wallet.service.otpService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import semicolon.africa.wallet.service.otpService.WalletOtpService;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class otpServiceTest {

    private WalletOtpService walletOtpService;

    @Value("${twilio.account.sid}")
    private String twilioAccountSid;

    @Value("${twilio.auth.token}")
    private String twilioAuthToken;

    @Test
    public void testSendOtp() {
        // Set up Twilio with your credentials
        Twilio.init(twilioAccountSid, twilioAuthToken);

        // Recipient phone number (replace with a valid phone number)
        String recipientNumber = "+2348169717282";

        // Send OTP
        walletOtpService.sendOtp(recipientNumber);

        // In a real test, you should check the result more specifically.
        // For this basic example, we only check if the message body is not empty.
        // Adjust your assertions as needed.
        Message message = Message.fetcher("your_message_sid").fetch();
        assertTrue(message.getBody() != null && !message.getBody().isEmpty());
    }
}
