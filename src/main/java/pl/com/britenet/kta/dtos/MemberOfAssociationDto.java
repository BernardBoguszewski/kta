package pl.com.britenet.kta.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Britenet on 2017-07-17.
 */
@NoArgsConstructor
@Data
public class MemberOfAssociationDto {

    private String name;
    private String nip;
    private String regon;

    private String address;
    private String email;
    private String phoneNumber;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;
    private String memberOfAssociationType; //zwyczajny, honorowy, wspierajacy
    //private Note note; todo

    private Set<String> contributionsIds;

    private String resolutionId;
}
