package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("Wallet")
public class Wallet {
    @Id
    private String walletId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private ProfileUpdate profileUpdate;
    private BigDecimal balance;
    private String profileImage;
    private List<Transaction> transactions;
}
