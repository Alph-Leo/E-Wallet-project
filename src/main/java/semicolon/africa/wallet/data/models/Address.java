package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor@Document
public class Address {
    private String streetNo;
    private String StreetName;
    private String localGovernmentArea;
    private String state;
    private String country;
}
