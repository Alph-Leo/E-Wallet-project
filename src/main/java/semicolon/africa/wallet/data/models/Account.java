package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Account {
    @Id
    private String accountId;
    private Customer customer;
    private String accountNo;
    private AccountType accountType;
    private BigDecimal accountBalance;
    private List<Loan> loanList;
}
