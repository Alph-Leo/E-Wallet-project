package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("Wallet")
public class Wallet {
    @Id
    private String walletId;
    private BigDecimal balance;
    private User user;
    private List<Transaction> transactions;
}