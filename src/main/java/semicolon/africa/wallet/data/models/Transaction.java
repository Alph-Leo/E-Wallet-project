package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@Document("Transaction")
public class Transaction {
    @Id
    private String transactionId ;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String senderName;
    private String receiverName;

}
