package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("Notification")
public class Notification {
    @Id
    private String notificationId;
    private String transactionAlert;
    private String userId;
}
