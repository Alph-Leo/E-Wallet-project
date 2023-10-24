package semicolon.africa.wallet.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document("Card")
public class Card {
   private String serialNumber;
   private String expiryDate;
   private String cvv;

}
