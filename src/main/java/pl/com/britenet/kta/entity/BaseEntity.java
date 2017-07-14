package pl.com.britenet.kta.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.util.UUID;

@ToString
@Data
public class BaseEntity {

    @Id
    private BigInteger id;
    private String uuid;

    public BaseEntity() {
        uuid = UUID.randomUUID().toString();
    }
}
