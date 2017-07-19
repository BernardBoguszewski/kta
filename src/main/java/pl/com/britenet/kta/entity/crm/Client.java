package pl.com.britenet.kta.entity.crm;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;
import pl.com.britenet.kta.entity.note.Note;

public class Client {

    @Id
    private String id;

    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    private ContactType contactType; // BENEFICJENT, OSOBA_FIZYCZNA, FIRMA, ORGANIZACJA, URZAD
    private Note note;

    public Client() {
    }

    public Client(String name, String address, String email, String phoneNumber, ContactType contactType) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.contactType = contactType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
