package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.*;

@Getter
@Setter
public class RegistrationRequest {

    @Id
    private String walletId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private ProfileUpdate profileUpdate;

}
