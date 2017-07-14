package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.exceptions.BadRequestException;

/**
 * Created by Britenet on 2017-07-13.
 */
public class UserDto {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    public UserDto() {
    }

    public UserDto(String login, String password, String firstName, String lastName, String email, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public void validate() {
        if (login == null || login.trim().isEmpty())
            throw new BadRequestException("Login nie moze byc pusty");
        if (password == null || password.trim().isEmpty())
            throw new BadRequestException("Haslo nie moze byc puste");
        if (firstName == null || firstName.trim().isEmpty())
            throw new BadRequestException("Imie nie moze byc puste");
        if (lastName == null || lastName.trim().isEmpty())
            throw new BadRequestException("Nazwisko nie moze byc puste");
        if (email == null || email.trim().isEmpty())
            throw new BadRequestException("Email nie moze byc pusty");
        if (phoneNumber == null || phoneNumber.trim().isEmpty())
            throw new BadRequestException("Numer telefonu nie moze byc pusty");

    }
}
