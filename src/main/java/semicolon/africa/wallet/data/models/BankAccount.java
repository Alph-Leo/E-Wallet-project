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
@Document("Bank_Account")
public class BankAccount {
   private String bankName;
   private String accountNumber;
   private User accountHolder;
}
