package pl.com.britenet.kta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.britenet.kta.dtos.RoleDto;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<RoleDto> findAll() {
        return roleRepository.findAll().stream()
                .map(RoleService::mapToDto)
                .collect(Collectors.toList());
    }

    public RoleDto findOne(String id) {
        return Optional.ofNullable(roleRepository.findOne(id))
                .map(RoleService::mapToDto)
                .orElseThrow(() -> new RuntimeException("nie ma takiej roli"));
    }

    public static RoleDto mapToDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .roleType(role.getRoleType())
                .build();
    }
}
