package pl.com.britenet.kta.entity.membership;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;
import pl.com.britenet.kta.entity.note.Note;
import pl.com.britenet.kta.entity.resolution.Resolution;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class MemberOfAssociation {

    @Id
    private String id;

    private String name;
    private String nip;
    private String regon;


    private String address;
    private String email;
    private String phoneNumber;

    private LocalDate startDate;
    private LocalDate endDate;

    private MemberOfAssociationStatus status;
    private String memberOfAssociationType; //zwyczajny, honorowy, wspierajacy
    private Note note;

    //private Set<Contribution> contributions;

    @NotNull // członek nie moze byc dodany jesli nie ma podanej resolution (ktora dotyczy jego przyjecie do stowarzyszenia)
    // uchwała badź tylo numer uchwały
    private Resolution resolutions;

    public MemberOfAssociation() {
    }

    public MemberOfAssociation(String name, String nip, String regon, String address, String email, String phoneNumber, LocalDate startDate, LocalDate endDate, MemberOfAssociationStatus status, String memberOfAssociationType, Resolution resolutions) {
        this.name = name;
        this.nip = nip;
        this.regon = regon;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.memberOfAssociationType = memberOfAssociationType;
        this.resolutions = resolutions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public MemberOfAssociationStatus getStatus() {
        return status;
    }

    public void setStatus(MemberOfAssociationStatus status) {
        this.status = status;
    }

    public String getMemberOfAssociationType() {
        return memberOfAssociationType;
    }

    public void setMemberOfAssociationType(String memberOfAssociationType) {
        this.memberOfAssociationType = memberOfAssociationType;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Resolution getResolutions() {
        return resolutions;
    }

    public void setResolutions(Resolution resolutions) {
        this.resolutions = resolutions;
    }
}
