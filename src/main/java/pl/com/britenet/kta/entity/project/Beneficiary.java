package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;
import pl.com.britenet.kta.entity.project.Project;

import java.util.Set;

public class Beneficiary {


    @Id
    private String id;

    private BeneficiaryType beneficiaryType; //OSOBA_Z_AUTYZMEM, OTOCZENIE

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

    private Set<Project> projects;
    private int hoursOfSupport;

    public Beneficiary() {
    }

    public Beneficiary(BeneficiaryType beneficiaryType, String firstName, String lastName, String address, String email, String phoneNumber, int hoursOfSupport) {
        this.beneficiaryType = beneficiaryType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hoursOfSupport = hoursOfSupport;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BeneficiaryType getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(BeneficiaryType beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public int getHoursOfSupport() {
        return hoursOfSupport;
    }

    public void setHoursOfSupport(int hoursOfSupport) {
        this.hoursOfSupport = hoursOfSupport;
    }

    //    private String birthDate;
//
//    private boolean disabled; //niepelnosprawny
//    private String releaseDate; // dataWystawieniaZaswiadczenia
//    private String expirationDate; //dataWaznosciZaswiadczenia
//
////    //Otoczenie - z sekcji 1.1.10. Lista osób wpisana w projekty
////    private boolean parent;
////    private boolean siblings;
//
//    // z sekcji 1.1.10. Lista osób wpisana w projekty
////2.3. Nazwa projektu (możliwość wpisania więcej niż jednego)
//    private Set<Project> projects;
//    private int hoursOfSupport; //liczbaGodzinUdzielonegoWsparcia
//    private String year; ///rok ???
//    //private Note note;
}
