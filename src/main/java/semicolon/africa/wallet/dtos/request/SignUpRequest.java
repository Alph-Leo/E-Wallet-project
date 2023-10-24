package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {

    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
