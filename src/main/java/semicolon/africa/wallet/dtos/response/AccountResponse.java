package semicolon.africa.wallet.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.AccountType;
import semicolon.africa.wallet.data.models.Customer;
import semicolon.africa.wallet.data.models.Loan;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AccountResponse {

    @Id
    private String accountId;
    private Customer customer;
    private String accountNo;
    private AccountType accountType;
    private BigDecimal accountBalance;
    private List<Loan> loanList;
}
