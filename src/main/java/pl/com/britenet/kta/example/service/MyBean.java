package pl.com.britenet.kta.example.service;

import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class MyBean {

    private final MongoDbFactory mongo;

    @Autowired
    public MyBean(MongoDbFactory mongo) {
        this.mongo = mongo;
    }

    @PreDestroy
    public void example() {
        DB db = mongo.getDb();
        db.getCollectionNames().forEach(System.out::println);
        db.dropDatabase();
    }

}