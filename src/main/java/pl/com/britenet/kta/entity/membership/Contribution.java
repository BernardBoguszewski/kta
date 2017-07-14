package pl.com.britenet.kta.entity.membership;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;

import java.util.Date;

public class Contribution {

    @Id
    private String id;
    private String name; //członek to nie tylko osoba, ale np. firma lub instytucja, więc to pole musi mieć bardziej ogólną nazwę z możliwością dodatkowego wyboru: Imię, Nazwisko, w przypadku osoby. W przypadku firmy dane jak NIP i  REGON
    private Address address;
    private String email;
    private String phoneNumber;
    private MemberOfAssociation memberOfAssociation;

    private Date dateOfPayment;
    private ContributionDictionary contributionDictionary;
    private String description;
}
