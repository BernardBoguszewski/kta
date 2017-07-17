package pl.com.britenet.kta.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;

/**
 * Created by Britenet on 2017-07-17.
 */
public interface MemberOfAssociationRepository extends MongoRepository<MemberOfAssociation, String> {
}
