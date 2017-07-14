package pl.com.britenet.kta.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.com.britenet.kta.entity.user.RolaEnum;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.entity.user.User;

//@RestController(value = "/test")
public class UserController {

    @PostMapping
    public User addUser(@RequestBody User user) {
        System.out.println(user);
        User user1 = new User();
        Role role = new Role();
        role.setName(RolaEnum.ADMINISTRATOR);
        user1.setRole(role);
        return user1;
    }
}
