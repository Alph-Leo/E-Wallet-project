package semicolon.africa.wallet.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class AddressResponse {

    @Id
    private String addressId;
    private String houseNumber;
    private String street;
    private String localGovernmentArea;
    private String state;
    private String country;
}
