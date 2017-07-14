package pl.com.britenet.kta.entity.activities;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;

import java.util.Date;
import java.util.Set;

//Sekcja ma prezentować listę aktywności wykonywanych w Stowarzyszeniu, nie będących zajęciami terapeutycznymi, ani aktywnościami związanymi z projektami (np. porada, opinia, zaświadczenie, diagnoza). Sekcja ma pozwolić zrobić zestawienie okresowe aktywności.
//Rejestr aktywności to tylko:
//        Nie-projekty:
//        •	Inne, czyli: porada, opinia, zaświadczenie, diagnoza à te tzw. „inne” potrzebne są do utworzenia ich zestawienia okresowego
public class ActivityRegister {

    @Id
    private String id;
    private String title;
    private String description;

    private ActivityDictionary activityDictionary;
    private Set<String> contractors; //osoby realizujace zadania - osoby wpisane z palca

    private Date endDate; // data i godzina realizacji
    private int amountOfTime; //godziny i minuty
    private Note note;
}
