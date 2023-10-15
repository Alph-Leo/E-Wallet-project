package semicolon.africa.wallet.data.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import semicolon.africa.wallet.data.models.Notification;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
