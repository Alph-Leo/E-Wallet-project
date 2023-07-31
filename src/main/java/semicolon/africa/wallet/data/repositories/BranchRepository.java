package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Branch;

public interface BranchRepository extends MongoRepository<Branch, String> {
}
