package semicolon.africa.wallet.dtos.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String streetNo;
    private String StreetName;
    private String localGovernmentArea;
    private String state;
    private String country;
}
