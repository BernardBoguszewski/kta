package pl.com.britenet.kta.entity.resolution;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;

import java.util.Date;

public class Resolution {

    @Id
    private String id;
    private String title;
    private String description;
    private String numeration; //????
    private Date date;

    private Resolution previousResultion;
    private MemberOfAssociation memberOfAssociation; //????
}
