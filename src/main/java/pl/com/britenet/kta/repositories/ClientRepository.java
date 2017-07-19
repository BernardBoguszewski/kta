package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.entity.crm.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {


}
