package semicolon.africa.wallet.dtos.request;

import lombok.Data;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.Address;
import semicolon.africa.wallet.data.models.Branch;

import java.util.List;

@Data
public class BankRequest {

    @Id
    private String bankId;
    private String bankName;
    private String bankCode;
    private Address bankAddress;
    private List<Branch> bankBranches;
}
