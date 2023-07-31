package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Account> accounts;
    private Address address;
}
