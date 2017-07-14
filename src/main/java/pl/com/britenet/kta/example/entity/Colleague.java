package pl.com.britenet.kta.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.com.britenet.kta.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Document
public class Colleague extends BaseEntity {

    public String name;

//    @DBRef
    public List<Recognition> recognitions;

    public Colleague() {
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name) {
        this.name = name;
        this.recognitions = new ArrayList<>();
    }

    public Colleague(String name, List<Recognition> recognitions) {
        this.name = name;
        this.recognitions = recognitions;
    }
}
