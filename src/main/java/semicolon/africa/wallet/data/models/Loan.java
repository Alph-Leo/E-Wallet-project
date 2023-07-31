package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Loan {
    @Id
    private String loanId;
    private BigDecimal loanAmount;
    private BigDecimal loanInterestRate;
    private Account account;
    private LoanType typeOfLoan;
}
