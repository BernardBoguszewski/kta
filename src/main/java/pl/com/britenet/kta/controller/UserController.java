package pl.com.britenet.kta.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.entity.user.User;
import pl.com.britenet.kta.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findOne(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }
}
