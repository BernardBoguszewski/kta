package pl.com.britenet.kta.entity.activities;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

//Sekcja ma prezentować listę aktywności wykonywanych w Stowarzyszeniu, nie będących zajęciami terapeutycznymi, ani aktywnościami związanymi z projektami (np. porada, opinia, zaświadczenie, diagnoza). Sekcja ma pozwolić zrobić zestawienie okresowe aktywności.
//Rejestr aktywności to tylko:
//        Nie-projekty:
//        •	Inne, czyli: porada, opinia, zaświadczenie, diagnoza à te tzw. „inne” potrzebne są do utworzenia ich zestawienia okresowego
public class Activity {

    @Id
    private String id;
    private String title;
    private String description;

    private ActivityDictionary activityDictionary;
    private Set<String> contractors; //osoby realizujace zadania - osoby wpisane z palca

    private LocalDate endDate; // data i godzina realizacji
    private int amountOfTime; //godziny i minuty
    private Note note;

    public Activity() {
    }

    public Activity(String title, String description, ActivityDictionary activityDictionary, Set<String> contractors, LocalDate endDate, int amountOfTime) {
        this.title = title;
        this.description = description;
        this.activityDictionary = activityDictionary;
        this.contractors = contractors;
        this.endDate = endDate;
        this.amountOfTime = amountOfTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityDictionary getActivityDictionary() {
        return activityDictionary;
    }

    public void setActivityDictionary(ActivityDictionary activityDictionary) {
        this.activityDictionary = activityDictionary;
    }

    public Set<String> getContractors() {
        return contractors;
    }

    public void setContractors(Set<String> contractors) {
        this.contractors = contractors;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getAmountOfTime() {
        return amountOfTime;
    }

    public void setAmountOfTime(int amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
