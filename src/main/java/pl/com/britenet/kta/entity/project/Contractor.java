package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;

import java.util.Set;

//KADRA z projektu
public class Contractor {

    @Id
    private String id;

    private ContractorType contractorType;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

    private Set<Project> projects;

    public Contractor() {
    }

    public Contractor(ContractorType contractorType, String firstName, String lastName, String address, String email, String phoneNumber) {
        this.contractorType = contractorType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Contractor(ContractorType contractorType, String firstName, String lastName, String address, String email, String phoneNumber, Set<Project> projects) {
        this.contractorType = contractorType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.projects = projects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ContractorType getContractorType() {
        return contractorType;
    }

    public void setContractorType(ContractorType contractorType) {
        this.contractorType = contractorType;
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
}
