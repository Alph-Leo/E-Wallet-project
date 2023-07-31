package semicolon.africa.wallet.dtos.response;

import lombok.Data;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.Account;
import semicolon.africa.wallet.data.models.LoanType;

import java.math.BigDecimal;
@Data
public class LoanResponse {
    @Id
    private String loanId;
    private BigDecimal loanAmount;
    private BigDecimal loanInterestRate;
    private Account account;
    private LoanType typeOfLoan;
}
