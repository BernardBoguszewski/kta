package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.entity.resolution.Resolution;

/**
 * Created by Britenet on 2017-07-14.
 */
@Repository
public interface ResolutionRepository extends MongoRepository<Resolution, String> {


}
