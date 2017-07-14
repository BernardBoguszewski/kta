package pl.com.britenet.kta.entity.user;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@ToString
public class Role {

    @Id
    private String id;
    private RoleType roleType; // ADMINISTRATOR, ZARZAD, KSIEGOWA, TERAPEUTA, CZLONEK, WOLONTARIUSZ
    private Set<Permission> permissions;

    public Role() {
    }

    public Role(RoleType roleType, Set<Permission> permissions) {
        this.roleType = roleType;
        this.permissions = permissions;
    }
}
