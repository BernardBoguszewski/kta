package pl.com.britenet.kta.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.britenet.kta.dto.user.RoleDto;
import pl.com.britenet.kta.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("roles")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<RoleDto> getRoles() {
        return roleService.findAll();
    }

    @GetMapping(value = "/{id}")
    public RoleDto getRole(@PathVariable String id) {
        return roleService.findOne(id);
    }
}
