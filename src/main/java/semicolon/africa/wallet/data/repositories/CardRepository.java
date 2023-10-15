package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Card;

public interface CardRepository extends MongoRepository<Card, String> {
}
