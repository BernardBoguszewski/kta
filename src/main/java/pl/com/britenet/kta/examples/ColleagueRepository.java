package pl.com.britenet.kta.examples;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
public interface ColleagueRepository extends MongoRepository<Colleague, String> {

    public List<Colleague> findByName(String name);
}
