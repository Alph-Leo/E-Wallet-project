package semicolon.africa.wallet.dtos.response;

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
public class TransactionResponse {

    @Id
    private String transactionId ;
    private String message;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
}
