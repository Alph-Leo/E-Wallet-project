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
import java.util.stream.Collectors;

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
        customer.setAccounts(customerRequest.getAccounts());
        customer.setAddress(customerRequest.getAddress());

        Customer savedCustomer = customerRepository.save(customer);
        log.info("New customer registered successfully");
        return listOfCustomers(savedCustomer);
    }
//    private void addAccount(String phoneNumber, Account account){
//        customerRepository.findCustomerByPhoneNumber(phoneNumber).getAccounts().add(account);
//    }
//    public  void createdAccount(AccountRequest accountRequest, String phone){
//
//        addAccount(phone,accountService.createAccount(accountRequest));
//    }

    @Override
    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer Not Found"));

        customer.setAddress(customerRequest.getAddress());
        customer.setFirstName(customerRequest.getFirstName());
        customer.setLastName(customerRequest.getLastName());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setEmail(customerRequest.getEmail());
        customer.setPassword(customer.getPassword());
        customer.setAccounts(customerRequest.getAccounts());
        customer.setAddress(customerRequest.getAddress());

        Customer updatedCustomer = customerRepository.save(customer);
        log.info("Customer account updated successfully ");

        return listOfCustomers(updatedCustomer);
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
        return new CustomerResponse();
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::listOfCustomers)
                .collect(Collectors.toList());
    }

    private  CustomerResponse listOfCustomers(Customer customer){
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setAddress(customer.getAddress());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setPhoneNumber(customer.getPhoneNumber());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setAccounts(customer.getAccounts());
        customerResponse.setAddress(customer.getAddress());

        return customerResponse;

    }
}
