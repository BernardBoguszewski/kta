package pl.com.britenet.kta.entity.crm;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;
import pl.com.britenet.kta.entity.note.Note;

public class Client {

    @Id
    private String id;

    private Address address;
    private String email;
    private String phoneNumber;

    private ContactType contactType; // BENEFICJENT, OSOBA_FIZYCZNA, FIRMA, ORGANIZACJA, URZAD
    private Note note;
}
