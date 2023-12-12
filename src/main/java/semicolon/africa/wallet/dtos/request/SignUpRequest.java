package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class SignUpRequest {
    @Id
    private String userId;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
