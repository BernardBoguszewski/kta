package pl.com.britenet.kta.entity.resolution;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Resolution {

    @Id
    private String id;
    private String title;
    private String description;
    private String numeration; //????
    private LocalDate date;

    private Resolution previousResultion;
    private MemberOfAssociation memberOfAssociation; //????

    public Resolution(String title, String description, String numeration, LocalDate date, Resolution previousResultion, MemberOfAssociation memberOfAssociation) {
        this.title = title;
        this.description = description;
        this.numeration = numeration;
        this.date = date;
        this.previousResultion = previousResultion;
        this.memberOfAssociation = memberOfAssociation;
    }
}
