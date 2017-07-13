package pl.com.britenet.kta.factories;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.domain.User;
import pl.com.britenet.kta.dtos.UserDto;

/**
 * Created by Britenet on 2017-07-13.
 */
@Component
public class UserFactory {

    public UserFactory() {
    }

    public User create(UserDto userDto){
        return new User(userDto.getLogin(), userDto.getPassword(), userDto.getFirstName(), userDto.getLastName(),
                userDto.getEmail(), userDto.getPhoneNumber());
    }
}
