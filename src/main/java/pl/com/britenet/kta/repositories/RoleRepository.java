package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.entity.user.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
}
