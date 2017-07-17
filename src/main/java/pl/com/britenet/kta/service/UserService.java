package pl.com.britenet.kta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.britenet.kta.dto.user.RoleDto;
import pl.com.britenet.kta.dto.user.UserDto;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.entity.user.User;
import pl.com.britenet.kta.repository.RoleRepository;
import pl.com.britenet.kta.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserService::mapToDto)
                .collect(Collectors.toList());
    }

    public UserDto findOne(String id) {
        return Optional.ofNullable(userRepository.findOne(id))
                .map(UserService::mapToDto)
                .orElseThrow(() -> new RuntimeException("nie ma takiego usera"));
    }

    public UserDto add(UserDto userDto) {
        Role role = Optional.ofNullable(userDto.getRole().getId())
                .map(roleRepository::findOne)
                .filter(r -> r.getRoleType().equals(userDto.getRole().getRoleType()))
                .orElseThrow(
                        () -> new RuntimeException("nie ma takiej roli")
                );
        User user = createEntity(userDto, role);
        return mapToDto(userRepository.save(user));
    }

    public static User createEntity(UserDto userDto, Role role) {
        return User.builder()
                .login(userDto.getLogin())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .role(role)
                .build();
    }

    public static UserDto mapToDto(User user) {
        RoleDto roleDto = Optional.ofNullable(user.getRole()).map(RoleService::mapToDto).orElse(null);
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(roleDto)
                .build();
    }
}
