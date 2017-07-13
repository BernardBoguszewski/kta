package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.enums.ContactType;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Contact {

    @Id
    private String id;

    private String firstName;
    private String lastNsme;
    private Address address;
    private ContactType contactType;

}
