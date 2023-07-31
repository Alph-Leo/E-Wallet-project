package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Account;
import semicolon.africa.wallet.data.repositories.AccountRepository;
import semicolon.africa.wallet.dtos.request.AccountRequest;
import semicolon.africa.wallet.dtos.response.AccountResponse;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceWallet implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountResponse createAccount(AccountRequest accountRequest) {
        Account account = new Account();
        account.setAccountId(accountRequest.getAccountId());
        account.setAccountNo(accountRequest.getAccountNo());
        account.setAccountBalance(accountRequest.getAccountBalance());
        account.setAccountType(accountRequest.getAccountType());
        account.setCustomer(accountRequest.getCustomer());
        account.setLoanList(accountRequest.getLoanList());

        Account savedAccount = accountRepository.save(account);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(savedAccount.getAccountId());
        accountResponse.setAccountNo(savedAccount.getAccountNo());
        accountResponse.setAccountBalance(savedAccount.getAccountBalance());
        accountResponse.setAccountType(savedAccount.getAccountType());
        accountResponse.setCustomer(savedAccount.getCustomer());
        log.info("Account created successfully ");

        return accountResponse ;
    }

    @Override
    public AccountResponse updateAccount(String id, AccountRequest accountRequest) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found"));

            account.setAccountNo(accountRequest.getAccountNo());
            account.setAccountType(accountRequest.getAccountType());
            account.setLoanList(accountRequest.getLoanList());

            Account updatedAccount = accountRepository.save(account);

            AccountResponse accountResponse = new AccountResponse();

            accountResponse.setAccountNo(updatedAccount.getAccountNo());
            accountResponse.setAccountType(updatedAccount.getAccountType());
            accountResponse.setLoanList(updatedAccount.getLoanList());

            log.info("Account successfully updated ");

        return accountResponse;
    }

    @Override
    public AccountResponse findAccount(String id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(account.getAccountId());
        accountResponse.setAccountNo(account.getAccountNo());
        accountResponse.setAccountBalance(account.getAccountBalance());
        accountResponse.setAccountType(account.getAccountType());
//        accountResponse.setCustomer(account.getCustomer());
//        accountResponse.setLoanList(account.getLoanList());

        return accountResponse;
    }

    @Override
    public List<AccountResponse> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream()
                .map(this::listOfAccounts)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(String id) {
        accountRepository.deleteById(id);

    }
    private AccountResponse listOfAccounts(Account account){

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(account.getAccountId());
        accountResponse.setAccountNo(account.getAccountNo());
        accountResponse.setAccountBalance(account.getAccountBalance());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setCustomer(account.getCustomer());
        accountResponse.setLoanList(account.getLoanList());

        return accountResponse;
    }
}
