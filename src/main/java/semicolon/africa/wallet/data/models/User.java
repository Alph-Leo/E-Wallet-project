package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("User")
public class User {
    @Id
    private String userId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String password;
    private Wallet wallet;
    private List<Payment> payment;
    private Notification notification;
    private List<Card> card;
    private List<BankAccount> bankAccount;
}
