package semicolon.africa.wallet.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Bank {
    @Id
    private String bankId;
    private String bankName;
    private String bankCode;
    private Address bankAddress;
    private List<Branch> bankBranches;
}
