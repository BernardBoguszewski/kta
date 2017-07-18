package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.entity.activities.Activity;

/**
 * Created by Britenet on 2017-07-18.
 */
@Repository
public interface ActivitiesRepository extends MongoRepository<Activity, String> {
}
