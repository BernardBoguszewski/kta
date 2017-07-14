package pl.com.britenet.kta.entity.membership;

import org.springframework.data.annotation.Id;

public class ContributionDictionary {

    @Id
    private String id;
    private int value;
    private int year;
}
