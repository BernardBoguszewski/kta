package pl.com.britenet.kta.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.example.entity.Recognition;

public interface RecognitionRepository extends MongoRepository<Recognition, String> {
}
