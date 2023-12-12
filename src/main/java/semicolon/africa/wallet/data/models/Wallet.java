package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString
@Document("Wallet")
public class Wallet {
    @Id
    private String walletId;
    private BigDecimal balance;
    private User user;
    private List<Transaction> transactions;
}
