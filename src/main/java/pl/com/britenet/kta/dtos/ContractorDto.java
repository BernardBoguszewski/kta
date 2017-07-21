package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.exceptions.BadRequestException;

public class ContractorDto {

    private String contractorType;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;

    public ContractorDto() {
    }

    public ContractorDto(String contractorType, String firstName, String lastName, String address, String email, String phoneNumber) {
        this.contractorType = contractorType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getContractorType() {
        return contractorType;
    }

    public void setContractorType(String contractorType) {
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

    public void validate(){
        if (contractorType.trim().isEmpty())
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
    }
}
