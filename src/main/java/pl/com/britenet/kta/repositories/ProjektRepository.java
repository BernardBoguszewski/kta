package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.domain.Projekt;

/**
 * Created by Britenet on 2017-07-13.
 */
@Repository
public interface ProjektRepository extends MongoRepository<Projekt, String> {
}