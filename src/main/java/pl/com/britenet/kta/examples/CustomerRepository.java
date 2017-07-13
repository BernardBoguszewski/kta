package pl.com.britenet.kta.examples;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by Britenet on 2017-07-12.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);
}
