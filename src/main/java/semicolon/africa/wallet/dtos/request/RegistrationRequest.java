package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.*;

import java.util.List;
@Getter
@Setter
public class RegistrationRequest {

    @Id
    private String userId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private String addressId;
    private String houseNumber;
    private String street;
    private String localGovernmentArea;
    private String state;
    private String country;
    private Wallet wallet;
}
