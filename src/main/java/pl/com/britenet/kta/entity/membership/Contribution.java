package pl.com.britenet.kta.entity.membership;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;

import java.time.LocalDate;
import java.util.Date;

public class Contribution {

    @Id
    private String id;
    private MemberOfAssociation memberOfAssociation;

    private LocalDate dateOfPayment;
    //private ContributionDictionary contributionDictionary;
    private String description;

    public Contribution() {
    }

    public Contribution(MemberOfAssociation memberOfAssociation, LocalDate dateOfPayment, String description) {
        this.memberOfAssociation = memberOfAssociation;
        this.dateOfPayment = dateOfPayment;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MemberOfAssociation getMemberOfAssociation() {
        return memberOfAssociation;
    }

    public void setMemberOfAssociation(MemberOfAssociation memberOfAssociation) {
        this.memberOfAssociation = memberOfAssociation;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
