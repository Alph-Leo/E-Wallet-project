package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.BankAccount;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
}
