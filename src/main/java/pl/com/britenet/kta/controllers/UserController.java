package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.domain.User;
import pl.com.britenet.kta.dtos.UserDto;
import pl.com.britenet.kta.services.UserService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto){
        userDto.validate();
        userService.createUser(userDto);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.listAllUsers();
    }
}
