package semicolon.africa.wallet.service;

import semicolon.africa.wallet.dtos.request.CustomerRequest;
import semicolon.africa.wallet.dtos.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    CustomerResponse registerCustomer(CustomerRequest customerRequest);
    CustomerResponse updateCustomer(CustomerRequest customerRequest);
    CustomerResponse findCustomerByPhoneNumber(String phoneNumber);
    List<CustomerResponse> findAllCustomers();
}
