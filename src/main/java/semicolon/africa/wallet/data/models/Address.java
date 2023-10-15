package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
