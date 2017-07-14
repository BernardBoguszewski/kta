package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.crm.Beneficiary;
import pl.com.britenet.kta.entity.note.Note;

import java.util.Date;
import java.util.Set;

//podobne do jiry
public class Project {

    @Id
    private String id;
    private String name;
    private String description;

    private Date startDate;
    private Date endDate;

    private ProjectStatus status;
    private Note note;

    private Set<Contractor> contractors; //kadra, terapeuta lub wolontariusz - no ale to nie musi chyba być uzytkownik systemu??
    
//    private Set<Contact> contacts;
    private Set<Beneficiary> beneficiaries;

    private Set<Task> tasks; //ktore moga byc wybierane z aktywności, badz mogą być tworzone nowe customowe

//2.12. Dostępu do listy zadań, beneficjentów, Kadry w
// “Opisie projektu” - połączenie z sekcją Lista osób
// wpisana w projekty oraz Zadania i realizacja zadań.
}
