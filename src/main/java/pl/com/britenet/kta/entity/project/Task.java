package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class Task {

    @Id
    private String id;
    private String title;
    private String description;

    private Set<Contractor> contractors; //kto to? contractors wybierane z kadry - 1.3. Osoba/contractors przypisane do zadania

    private LocalDate createdDate;
    private LocalDate finishDate; //dataZakonczenia
    private LocalDate startDate;
    private LocalDate realizationDate; //dataRealizacji

    private TaskStatus status;
    private Note note;
    private Project project;
}
