package pl.com.britenet.kta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.entity.user.User;

public interface UserRepository extends MongoRepository<User, String> {

}
