package pl.com.britenet.kta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.entity.user.Role;

import java.math.BigInteger;

public interface RoleRepository extends MongoRepository<Role, BigInteger> {
}
