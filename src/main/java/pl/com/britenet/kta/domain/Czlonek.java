package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.enums.MemberStatus;
import pl.com.britenet.kta.enums.MemberType;

import java.util.Date;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Czlonek {

    @Id
    private String id;

    private String name;
    private Address address;
    private String email;
    private String phoneNumber;
    private Date membershipStart;
    private Date membershipEnd;
    private MemberStatus memberStatus;
    private MemberType memberType;
    private Notatka notatka;
    private String numerUchwaly;

    public Czlonek() {
    }

    public Czlonek(String name, Address address, String email, String phoneNumber, Date membershipStart, Date membershipEnd, MemberStatus memberStatus, MemberType memberType, Notatka notatka, String numerUchwaly) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipStart = membershipStart;
        this.membershipEnd = membershipEnd;
        this.memberStatus = memberStatus;
        this.memberType = memberType;
        this.notatka = notatka;
        this.numerUchwaly = numerUchwaly;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public Date getMembershipStart() {
        return membershipStart;
    }

    public void setMembershipStart(Date membershipStart) {
        this.membershipStart = membershipStart;
    }

    public Date getMembershipEnd() {
        return membershipEnd;
    }

    public void setMembershipEnd(Date membershipEnd) {
        this.membershipEnd = membershipEnd;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }

    public String getNumerUchwaly() {
        return numerUchwaly;
    }

    public void setNumerUchwaly(String numerUchwaly) {
        this.numerUchwaly = numerUchwaly;
    }
}
