package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.entity.Address;
import pl.com.britenet.kta.entity.crm.ContactType;
import pl.com.britenet.kta.exceptions.BadRequestException;

public class ClientDto {

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String contactType;

    public ClientDto() {
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

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public void validate(){
        if (name.trim().isEmpty())
            throw new BadRequestException("Name can not be empty");
        if (address.trim().isEmpty())
            throw new BadRequestException("Address can not be empty");
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            throw new BadRequestException("Incorrect email format");
        if (!phoneNumber.matches("^\\d{9}$"))
            throw new BadRequestException("Incorrect phone number, just use 9 digits, like 123123123");
        if (contactType.trim().isEmpty())
            throw new BadRequestException("Name can not be empty");
    }
}
