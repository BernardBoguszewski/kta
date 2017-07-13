package pl.com.britenet.kta.dtos;

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
        // TODO: 2017-07-13 walidacja dtosa
    }
}
