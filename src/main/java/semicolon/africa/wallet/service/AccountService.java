package semicolon.africa.wallet.service;

import semicolon.africa.wallet.dtos.request.AccountRequest;
import semicolon.africa.wallet.dtos.response.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountResponse createAccount(AccountRequest accountRequest);
    AccountResponse updateAccount(String id, AccountRequest accountRequest);
    AccountResponse findAccount(String id);
    List<AccountResponse> findAllAccounts();
    void deleteAccount(String id);
}
