package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
