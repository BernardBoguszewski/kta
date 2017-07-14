package pl.com.britenet.kta.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.enums.ContactType;

/**
 * Created by Britenet on 2017-07-13.
 */
@Data
public class Contact {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String address;
    private ContactType contactType;

}
