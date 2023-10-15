package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Payment;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
