package pl.com.britenet.kta.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.repository.RoleRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findOne(String id) {
        return roleRepository.findOne(id);
    }
}
