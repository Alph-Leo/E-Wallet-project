package semicolon.africa.wallet.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import semicolon.africa.wallet.data.models.AccountType;
import semicolon.africa.wallet.data.models.Customer;
import semicolon.africa.wallet.data.models.Loan;
import semicolon.africa.wallet.dtos.request.AccountRequest;
import semicolon.africa.wallet.dtos.response.AccountResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class AccountServiceWalletTest {
    @Autowired
    private AccountServiceWallet accountServiceWallet;

    @Test
    void createAccount() {
        AccountRequest accountRequest = new AccountRequest();
        List<Loan> loans = new ArrayList<>();
        Customer customer = new Customer();
        accountRequest.setAccountId("1");
        accountRequest.setAccountNo("12345");
        accountRequest.setAccountBalance(BigDecimal.valueOf(1000.00));
        accountRequest.setAccountType(AccountType.SAVINGS);
        accountRequest.setCustomer(customer);
        accountRequest.setLoanList(loans);

        AccountResponse accountResponse = accountServiceWallet.createAccount(accountRequest);

        assertNotNull(accountResponse);

    }

    @Test
    void updateAccount() {
        AccountRequest accountRequest = new AccountRequest();
//        accountRequest.setAccountId("1");
        accountRequest.setAccountNo("12345");
//        accountRequest.setAccountBalance(BigDecimal.valueOf(1000.00));
        accountRequest.setAccountType(AccountType.SAVINGS);
//        accountRequest.setCustomer(new Customer());
        accountRequest.setLoanList(new ArrayList<>());

        AccountResponse accountResponse = accountServiceWallet.createAccount(accountRequest);
        assertNotNull(accountResponse);

        AccountRequest updateAccountRequest = new AccountRequest();
//        updateAccountRequest.setAccountId("1");
        updateAccountRequest.setAccountNo("67890");
//        updateAccountRequest.setAccountBalance(BigDecimal.valueOf(500.00));
        updateAccountRequest.setAccountType(AccountType.CURRENT);
//        updateAccountRequest.setCustomer(new Customer());
        updateAccountRequest.setLoanList(new ArrayList<>());

        AccountResponse updatedAccount = accountServiceWallet.updateAccount("1", updateAccountRequest);
        assertNotNull(updatedAccount);
//        assertEquals("1", updatedAccount.getAccountId());
        assertEquals("67890", updateAccountRequest.getAccountNo());
//        assertEquals(BigDecimal.valueOf(500.00), updatedAccount.getAccountBalance());
        assertEquals(AccountType.CURRENT, updatedAccount.getAccountType());

        AccountResponse foundAccount = accountServiceWallet.findAccount("1");
        assertNotNull(foundAccount);

//        assertEquals("1", foundAccount.getAccountId());
        assertEquals("67890", foundAccount.getAccountNo());
//        assertEquals(BigDecimal.valueOf(500.00), foundAccount.getAccountBalance());
        assertEquals(AccountType.CURRENT, foundAccount.getAccountType());
    }

    @Test
    void findAccount() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setAccountId("1");
        accountRequest.setAccountNo("12345");
        accountRequest.setAccountBalance(BigDecimal.valueOf(1000.00));
        accountRequest.setAccountType(AccountType.SAVINGS);
        accountRequest.setCustomer(new Customer());
        accountRequest.setLoanList(new ArrayList<>());

        AccountResponse accountResponse = accountServiceWallet.createAccount(accountRequest);

        AccountRequest accountRequest1 = new AccountRequest();
        accountRequest1.setAccountId("2");
        accountRequest1.setAccountNo("67890");
        accountRequest1.setAccountBalance(BigDecimal.valueOf(1500.00));
        accountRequest1.setAccountType(AccountType.CURRENT);
        accountRequest1.setCustomer(new Customer());
        accountRequest1.setLoanList(new ArrayList<>());

        AccountResponse accountResponse1 = accountServiceWallet.createAccount(accountRequest1);

        assertNotNull(accountResponse);
        assertNotNull(accountResponse1);
        AccountResponse foundAccount = accountServiceWallet.findAccount("2");
        assertNotNull(foundAccount);

        assertEquals("2", foundAccount.getAccountId());
        assertEquals("67890", foundAccount.getAccountNo());
        assertEquals(BigDecimal.valueOf(1500.00), foundAccount.getAccountBalance());
        assertEquals(AccountType.CURRENT, foundAccount.getAccountType());


    }

    @Test
    void findAllAccounts() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setAccountId("1");
        accountRequest.setAccountNo("12345");
        accountRequest.setAccountBalance(BigDecimal.valueOf(1000.00));
        accountRequest.setAccountType(AccountType.SAVINGS);
        accountRequest.setCustomer(new Customer());
        accountRequest.setLoanList(new ArrayList<>());

        AccountResponse accountResponse = accountServiceWallet.createAccount(accountRequest);

        AccountRequest accountRequest1 = new AccountRequest();
        accountRequest1.setAccountId("2");
        accountRequest1.setAccountNo("67890");
        accountRequest1.setAccountBalance(BigDecimal.valueOf(1500.00));
        accountRequest1.setAccountType(AccountType.CURRENT);
        accountRequest1.setCustomer(new Customer());
        accountRequest1.setLoanList(new ArrayList<>());

        AccountResponse accountResponse1 = accountServiceWallet.createAccount(accountRequest1);

        assertNotNull(accountResponse);
        assertNotNull(accountResponse1);

        assertEquals(2, accountServiceWallet.findAllAccounts().size());
    }

    @Test
    void deleteAccount() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setAccountId("1");
        accountRequest.setAccountNo("12345");
        accountRequest.setAccountBalance(BigDecimal.valueOf(1000.00));
        accountRequest.setAccountType(AccountType.SAVINGS);
        accountRequest.setCustomer(new Customer());
        accountRequest.setLoanList(new ArrayList<>());

        AccountResponse accountResponse = accountServiceWallet.createAccount(accountRequest);

        AccountRequest accountRequest1 = new AccountRequest();
        accountRequest1.setAccountId("2");
        accountRequest1.setAccountNo("67890");
        accountRequest1.setAccountBalance(BigDecimal.valueOf(1500.00));
        accountRequest1.setAccountType(AccountType.CURRENT);
        accountRequest1.setCustomer(new Customer());
        accountRequest1.setLoanList(new ArrayList<>());

        AccountResponse accountResponse1 = accountServiceWallet.createAccount(accountRequest);

        assertNotNull(accountResponse);
        assertNotNull(accountResponse1);

        accountServiceWallet.deleteAccount("2");
        assertEquals(1, accountServiceWallet.findAllAccounts().size());
    }
}