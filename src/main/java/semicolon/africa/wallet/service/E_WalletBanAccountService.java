package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.BankAccount;
import semicolon.africa.wallet.data.repositories.BankAccountRepository;
import semicolon.africa.wallet.dtos.request.BankAccountRequest;
import semicolon.africa.wallet.dtos.response.BankAccountResponse;
@Service
@RequiredArgsConstructor
public class E_WalletBanAccountService implements BankAccountService{
    private final BankAccountRepository bankAccountRepository;
    @Override
    public BankAccountResponse creatAccount(BankAccountRequest bankAccountRequest) {
        BankAccount bankAccount = new BankAccount();
//        bankAccount.setAccountHolder(bankAccountRequest.getAccountHolder());
        bankAccount.setAccountNumber(bankAccountRequest.getAccountNumber());
        bankAccount.setBankName(bankAccountRequest.getBankName());

        BankAccountResponse bankAccountResponse = getBankAccountResponse(bankAccount);

        return bankAccountResponse;
    }

    @NotNull
    private BankAccountResponse getBankAccountResponse(BankAccount bankAccount) {
        BankAccount response = bankAccountRepository.save(bankAccount);
        BankAccountResponse bankAccountResponse = new BankAccountResponse();
//        bankAccountResponse.setAccountHolder(response.getAccountHolder());
        bankAccountResponse.setAccountNumber(response.getAccountNumber());
        bankAccountResponse.setBankName(response.getBankName());
        return bankAccountResponse;
    }
}
