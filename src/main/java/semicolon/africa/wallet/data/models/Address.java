package semicolon.africa.wallet.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Address")
public class Address {
    @Id
    private String addressId;
    private String houseNumber;
    private String street;
    private String localGovernmentArea;
    private String state;
    private String country;
}
