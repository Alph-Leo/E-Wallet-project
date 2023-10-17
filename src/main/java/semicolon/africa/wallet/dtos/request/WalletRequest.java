package semicolon.africa.wallet.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import semicolon.africa.wallet.data.models.Transaction;
import semicolon.africa.wallet.data.models.User;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
public class WalletRequest {

    @Id
    private String walletId;
    private BigDecimal balance;
    private User user;
    private List<Transaction> transactions;
}
