package pl.com.britenet.kta.entity.user;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.user.Role;

@Data
@Document
public class User extends BaseEntity {

    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private Role role;
}
