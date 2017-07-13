package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Contribution {

    @Id
    private String id;

    private Czlonek czlonek;
    private Date contributionDate;
    private int year;
    private String description;

    public Contribution(Czlonek czlonek, Date contributionDate, int year, String description) {
        this.czlonek = czlonek;
        this.contributionDate = contributionDate;
        this.year = year;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Czlonek getCzlonek() {
        return czlonek;
    }

    public void setCzlonek(Czlonek czlonek) {
        this.czlonek = czlonek;
    }

    public Date getContributionDate() {
        return contributionDate;
    }

    public void setContributionDate(Date contributionDate) {
        this.contributionDate = contributionDate;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
