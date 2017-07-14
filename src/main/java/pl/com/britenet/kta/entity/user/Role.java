package pl.com.britenet.kta.entity.user;

import lombok.Data;
import pl.com.britenet.kta.entity.BaseEntity;

import java.util.Set;

@Data
public class Role extends BaseEntity {

    private RolaEnum name; // ADMINISTRATOR, ZARZAD, KSIEGOWA, TERAPEUTA, CZLONEK, WOLONTARIUSZ
    private Set<Permission> permissions;
}
