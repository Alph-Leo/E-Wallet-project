package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Loan;

public interface LoanRepository extends MongoRepository<Loan, String > {
}
