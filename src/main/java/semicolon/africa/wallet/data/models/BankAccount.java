package semicolon.africa.wallet.data.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@ToString
@Getter
@Setter
@Document("Bank_Account")
public class BankAccount {
   private String bankName;
   private String accountNumber;
   private String accountHolder;
}
