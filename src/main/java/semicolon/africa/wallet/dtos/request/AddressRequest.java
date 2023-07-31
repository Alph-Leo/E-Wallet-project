package semicolon.africa.wallet.dtos.request;

import lombok.Data;

@Data
public class AddressRequest {

    private String streetNo;
    private String StreetName;
    private String localGovernmentArea;
    private String state;
    private String country;
}
