package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
}
