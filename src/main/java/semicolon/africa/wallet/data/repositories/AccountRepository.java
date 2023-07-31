package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
}
