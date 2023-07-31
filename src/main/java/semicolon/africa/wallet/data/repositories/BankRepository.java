package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Bank;

public interface BankRepository extends MongoRepository<Bank, Long> {
}
