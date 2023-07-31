package semicolon.africa.wallet.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import semicolon.africa.wallet.data.models.Account;
import semicolon.africa.wallet.data.models.Customer;
import semicolon.africa.wallet.data.repositories.CustomerRepository;
import semicolon.africa.wallet.dtos.request.AccountRequest;
import semicolon.africa.wallet.dtos.request.CustomerRequest;
import semicolon.africa.wallet.dtos.response.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceWallet implements CustomerService{

    private final CustomerRepository customerRepository;
    private final  AccountService accountService;
    @Override
    public CustomerResponse registerCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setAddress(customerRequest.getAddress());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setEmail(customerRequest.getEmail());
        customer.setPassword(customer.getPassword());
//        customer.setAccounts(new ArrayList<>());
        return null;
    }
    private void addAccount(String phoneNumber, Account account){
        customerRepository.findCustomerByPhoneNumber(phoneNumber).getAccounts().add(account);
    }
    public  void createdAccount(AccountRequest accountRequest, String phone){

//        addAccount(phone,accountService.createAccount(accountRequest));
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @Override
    public CustomerResponse findCustomerByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository.findCustomerByPhoneNumber(phoneNumber);
        if (customer != null){
            CustomerResponse customerResponse = new CustomerResponse();
            customerResponse.setCustomerId(customer.getCustomerId());
            customerResponse.setFirstName(customer.getFirstName());
            customerResponse.setLastName(customer.getLastName());
            customerResponse.setPhoneNumber(customer.getPhoneNumber());
            customerResponse.setEmail(customer.getEmail());
            
        }
        return null;
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return null;
    }
}
