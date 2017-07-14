package pl.com.britenet.kta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.com.britenet.kta.entity.user.User;

import java.math.BigInteger;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends MongoRepository<User, BigInteger> {

}
