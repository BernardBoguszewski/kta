package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.activities.ActivityDictionary;
import pl.com.britenet.kta.entity.crm.Client;
import pl.com.britenet.kta.entity.note.Note;

import java.time.LocalDateTime;
import java.util.Set;

public class SupportRegistry {

    @Id
    private String id;
    private ActivityDictionary activityDictionary;
    private String description;

    //jesli jestem uztykownikiem z rolą terapueta wykonawca to moje np. imie i nazwisko,
    // jesli jestem w zarzadzie i jestem administartorem to pole jest edytowalne
    private String contractor;
    private LocalDateTime date;

    //wybieramy ze wszystkich projektów
    private Project project;//czy zwiazane z projektem

    private Set<Client> participants; //wszyscy z crm

    private int numberOfHours; //domyślnie 1
    private Note note;
}
