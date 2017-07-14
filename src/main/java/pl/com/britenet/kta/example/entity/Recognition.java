package pl.com.britenet.kta.example.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.com.britenet.kta.entity.BaseEntity;

@ToString
@Data
@Document
public class Recognition extends BaseEntity {

    private String description;

    public Recognition() {
    }

    public Recognition(String description) {
        this.description = description;
    }
}
