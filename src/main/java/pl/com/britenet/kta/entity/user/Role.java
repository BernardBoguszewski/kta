package pl.com.britenet.kta.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Builder
@ToString
@Document
@AllArgsConstructor
public class Role {

    @Id
    private String id;
    private RoleType roleType; // ADMINISTRATOR, ZARZAD, KSIEGOWA, TERAPEUTA, CZLONEK, WOLONTARIUSZ
    private Set<Permission> permissions;
}
