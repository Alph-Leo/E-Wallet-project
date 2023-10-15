package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Transaction")
public class Transaction {
    @Id
    private String transactionId ;
    private TransactionType transactionType;
    private BigDecimal amount;
    private User sender;
    private User receiver;
    private Wallet wallet;
}
