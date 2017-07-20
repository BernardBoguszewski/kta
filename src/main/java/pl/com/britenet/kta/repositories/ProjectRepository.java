package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.com.britenet.kta.entity.project.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String>{
}
