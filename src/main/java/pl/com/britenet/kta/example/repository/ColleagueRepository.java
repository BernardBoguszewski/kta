package pl.com.britenet.kta.example.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.example.entity.Colleague;

import java.util.List;

public interface ColleagueRepository extends MongoRepository<Colleague, String> {

    List<Colleague> findByName(String name);

}
