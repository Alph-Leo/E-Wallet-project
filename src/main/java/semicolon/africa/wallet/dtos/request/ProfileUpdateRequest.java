package semicolon.africa.wallet.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProfileUpdateRequest {

    @Id
    private String addressId;
    private String houseNumber;
    private String street;
    private String localGovernmentArea;
    private String state;
    private String country;
    private MultipartFile profileImage;
}
