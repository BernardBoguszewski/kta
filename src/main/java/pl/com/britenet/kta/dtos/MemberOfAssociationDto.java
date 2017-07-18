package pl.com.britenet.kta.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Britenet on 2017-07-17.
 */
public class MemberOfAssociationDto {

    private String name;
    private String nip;
    private String regon;

    private String address;
    private String email;
    private String phoneNumber;

    private String startDate;
    private String endDate;

    private String status;
    private String memberOfAssociationType; //zwyczajny, honorowy, wspierajacy
    //private Note note; todo


    private String resolutionId;


    public MemberOfAssociationDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMemberOfAssociationType() {
        return memberOfAssociationType;
    }

    public void setMemberOfAssociationType(String memberOfAssociationType) {
        this.memberOfAssociationType = memberOfAssociationType;
    }

    public String getResolutionId() {
        return resolutionId;
    }

    public void setResolutionId(String resolutionId) {
        this.resolutionId = resolutionId;
    }
}
