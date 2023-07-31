package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long> {
    Customer findCustomerByPhoneNumber(String phoneNumber);
}
