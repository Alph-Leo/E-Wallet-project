package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Document("Payment")
public class Payment {
    @Id
    private String paymentId;
    private PaymentType paymentType;
    private LocalDateTime dateTime;

}
