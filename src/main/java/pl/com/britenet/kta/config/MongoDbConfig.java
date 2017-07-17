package pl.com.britenet.kta.config;

import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;

import javax.annotation.PreDestroy;

@Profile("local")
@Configuration
public class MongoDbConfig {

    private final MongoDbFactory mongo;

    @Autowired
    public MongoDbConfig(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    @PreDestroy
    public void dropDatabase() {
        DB db = mongo.getDb();
        db.dropDatabase();
    }
}
