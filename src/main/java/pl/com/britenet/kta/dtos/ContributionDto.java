package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.exceptions.BadRequestException;

import java.time.LocalDate;

public class ContributionDto {

    private String memberOfAssociationId;
    private String dateOfPayment;
    private String description;

    public ContributionDto() {
    }

    public String getMemberOfAssociationId() {
        return memberOfAssociationId;
    }

    public void setMemberOfAssociationId(String memberOfAssociationId) {
        this.memberOfAssociationId = memberOfAssociationId;
    }

    public String getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void validate(){
        if(memberOfAssociationId.trim().isEmpty())
            throw new BadRequestException("Member id can not be empty");
        if(description.trim().isEmpty())
            throw new BadRequestException("Description can not be empty");
        if(!dateOfPayment.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
            throw new BadRequestException("Inproper date format, year-month-day");
    }
}
