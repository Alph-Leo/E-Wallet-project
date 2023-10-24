package semicolon.africa.wallet.dtos.response;

import lombok.Getter;
import lombok.Setter;
import semicolon.africa.wallet.data.models.User;
@Getter
@Setter
public class BankAccountResponse {
    private String bankName;
    private String accountNumber;
    private User accountHolder;
}
