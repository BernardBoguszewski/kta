package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Konto {

    @Id
    private String id;

    private Address address;
    private List<Contact> contacts;
    private Notatka notatka;

    public Konto(Address address, List<Contact> contacts, Notatka notatka) {
        this.address = address;
        this.contacts = contacts;
        this.notatka = notatka;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }
}

