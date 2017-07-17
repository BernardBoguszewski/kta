package pl.com.britenet.kta.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pl.com.britenet.kta.entity.user.RoleType;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {

    private String id;
    private RoleType roleType;
}
