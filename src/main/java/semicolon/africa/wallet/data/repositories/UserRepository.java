package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByEmail(String email);
    User findUserByPhoneNumber(String phoneNumber);
}