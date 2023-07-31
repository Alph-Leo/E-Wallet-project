package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor@AllArgsConstructor@Document
public class Branch {
    @Id
    private String branchId;
    private String branchName;
    private Address branchAddress;
    private Bank bank;
    private List<Account> accountList;
}
