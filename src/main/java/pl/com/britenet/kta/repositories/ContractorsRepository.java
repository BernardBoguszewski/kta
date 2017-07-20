package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.entity.project.Contractor;

@Repository
public interface ContractorsRepository extends MongoRepository<Contractor, String> {
}
