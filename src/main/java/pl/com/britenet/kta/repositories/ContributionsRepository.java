package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.britenet.kta.entity.membership.Contribution;
import pl.com.britenet.kta.services.ContributionsService;

@Repository
public interface ContributionsRepository extends MongoRepository<Contribution, String> {
}
