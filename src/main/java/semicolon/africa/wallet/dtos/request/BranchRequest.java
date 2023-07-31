package semicolon.africa.wallet.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.Account;
import semicolon.africa.wallet.data.models.Address;
import semicolon.africa.wallet.data.models.Bank;

import java.util.List;

@Data
public class BranchRequest {
    @Id
    private String branchId;
    private String branchName;
    private Address branchAddress;
    private Bank bank;
    private List<Account> accountList;
}
