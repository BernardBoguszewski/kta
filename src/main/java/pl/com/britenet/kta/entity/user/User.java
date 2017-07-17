package pl.com.britenet.kta.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@Document
@AllArgsConstructor
public class User {

    @Id
    private String id;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;

    @NotNull
    private Role role;
}
