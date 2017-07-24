package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.exceptions.BadRequestException;

public class BeneficiaryDto {

    private String id;
    private String beneficiaryType; //OSOBA_Z_AUTYZMEM, OTOCZENIE
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private int hoursOfSupport;

    public BeneficiaryDto() {
    }

    public BeneficiaryDto(String beneficiaryType, String firstName, String lastName, String address, String email, String phoneNumber, int hoursOfSupport) {
        this.beneficiaryType = beneficiaryType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hoursOfSupport = hoursOfSupport;
    }

    public BeneficiaryDto(String id, String beneficiaryType, String firstName, String lastName, String address, String email, String phoneNumber, int hoursOfSupport) {
        this.id = id;
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

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
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

    public int getHoursOfSupport() {
        return hoursOfSupport;
    }

    public void setHoursOfSupport(int hoursOfSupport) {
        this.hoursOfSupport = hoursOfSupport;
    }

    public void validate(){
        if (beneficiaryType.trim().isEmpty())
            throw new BadRequestException("Contarctor type can not be empty");
        if (firstName.trim().isEmpty())
            throw new BadRequestException("First name can not be empty");
        if (lastName.trim().isEmpty())
            throw new BadRequestException("Last name can not be empty");
        if (address.trim().isEmpty())
            throw new BadRequestException("Address can not be empty");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new BadRequestException("Incorrect email format");
        if (!phoneNumber.matches("^\\d{9}$"))
            throw new BadRequestException("Incorrect phone number, just use 9 digits, like 123123123");
        if (hoursOfSupport < 0)
            throw new BadRequestException("Incorrect hours of support value");
    }
}
