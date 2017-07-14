package pl.com.britenet.kta.entity.user;

import lombok.Data;
import pl.com.britenet.kta.entity.BaseEntity;

@Data
public class Permission extends BaseEntity {
    private String description;
}
