package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import semicolon.africa.wallet.data.models.User;

@Getter
@Setter
public class BankAccountRequest {
    private String bankName;
    private String accountNumber;
    private User accountHolder;
}
