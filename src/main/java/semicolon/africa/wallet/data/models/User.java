package semicolon.africa.wallet.data.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Document("User")
public class User {
    @Id
    private String userId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private Address address;
    private Wallet wallet;
}
