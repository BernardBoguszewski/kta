package pl.com.britenet.kta.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.com.britenet.kta.dtos.RoleDto;

@ToString
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private String id;
    private String login;
    private String password;
    private String email;
    private String phoneNumber;
    private RoleDto role;
}
