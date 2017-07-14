package pl.com.britenet.kta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.entity.user.User;
import pl.com.britenet.kta.repository.RoleRepository;
import pl.com.britenet.kta.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(String id) {
        return userRepository.findOne(id);
    }

    public User add(User user) {
        Role userRole = Optional.ofNullable(user.getRole().getId())
                .map(roleRepository::findOne)
                .filter(role -> role.getRoleType().equals(user.getRole().getRoleType()))
                .orElseThrow(
                        () -> new RuntimeException("nie ma takiej roli")
                );
        user.setRole(userRole);
        return userRepository.save(user);
    }
}
