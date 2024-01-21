package semicolon.africa.wallet.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProfileUpdateResponse {

    @Id
    private String addressId;
    private String message;
}
