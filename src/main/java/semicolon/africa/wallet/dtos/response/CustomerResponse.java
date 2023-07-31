package semicolon.africa.wallet.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.Account;
import semicolon.africa.wallet.data.models.Address;

import java.util.List;

@Data
public class CustomerResponse {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<Account> accounts;
    private String email;
    private Address address;
}
