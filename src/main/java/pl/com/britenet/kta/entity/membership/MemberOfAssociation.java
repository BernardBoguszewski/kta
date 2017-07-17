package pl.com.britenet.kta.entity.membership;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.Address;
import pl.com.britenet.kta.entity.note.Note;
import pl.com.britenet.kta.entity.resolution.Resolution;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class MemberOfAssociation {

    @Id
    private String id;
    private String name;
    private String nip;
    private String regon;

    private String  address;
    private String email;
    private String phoneNumber;

    private Date startDate;
    private Date endDate;

    private MemberOfAssociationStatus status;
    private String memberOfAssociationType; //zwyczajny, honorowy, wspierajacy
    private Note note;

    private Set<Contribution> contributions;

    @NotNull // członek nie moze byc dodany jesli nie ma podanej resolution (ktora dotyczy jego przyjecie do stowarzyszenia)
    // uchwała badź tylo numer uchwały
    private Resolution resolutions;
}
