package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.domain.User;
import pl.com.britenet.kta.dtos.UserDto;
import pl.com.britenet.kta.factories.UserFactory;
import pl.com.britenet.kta.repositories.UserRepository;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private UserFactory userFactory;

    public UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Transactional
    public void createUser(UserDto userDto){
        User user = userFactory.create(userDto);
        userRepository.save(user);
    }

    @Transactional
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }
}
