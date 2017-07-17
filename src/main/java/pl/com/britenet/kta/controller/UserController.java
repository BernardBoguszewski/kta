package pl.com.britenet.kta.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dto.user.UserDto;
import pl.com.britenet.kta.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserDto getUser(@PathVariable String id) {
        return userService.findOne(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.add(userDto);
    }
}
