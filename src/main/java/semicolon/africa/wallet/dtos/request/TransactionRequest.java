package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Setter
@Getter
@ToString
public class TransactionRequest {

    @Id
    private String transactionId ;
    private TransactionType transactionType;
    private BigDecimal amount;
    private String senderId;
    private String receiverId;
    private LocalDateTime transactionDate;
}
