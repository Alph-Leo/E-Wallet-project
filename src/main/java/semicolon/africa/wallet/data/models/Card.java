package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("Card")
public class Card {
   private String serialNumber;
   private String expiryDate;
   private String cvv;
   private User user;

}
