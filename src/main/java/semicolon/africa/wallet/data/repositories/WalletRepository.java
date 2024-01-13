package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Wallet;

public interface WalletRepository extends MongoRepository<Wallet, String> {
    Wallet findUserByEmailOrPhoneNumber(String email, String phoneNumber);
//    boolean existByMail(String email);
//    boolean existByPhoneNumber(String phoneNumber);
}
