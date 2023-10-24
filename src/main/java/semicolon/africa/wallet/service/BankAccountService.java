package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.dtos.request.BankAccountRequest;
import semicolon.africa.wallet.dtos.response.BankAccountResponse;

public interface BankAccountService {
    BankAccountResponse creatAccount(BankAccountRequest bankAccountRequest);
}
