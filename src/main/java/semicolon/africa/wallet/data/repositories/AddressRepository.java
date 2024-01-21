package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.ProfileUpdate;

public interface AddressRepository extends MongoRepository<ProfileUpdate, String> {
}
