package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;

import java.time.LocalDate;
import java.util.Set;

//podobne do jiry


public class Project {

    @Id
    private String id;
    private String name;
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    private ProjectStatus status;
    private Note note;

    private Set<Contractor> contractors; //kadra, terapeuta lub wolontariusz - no ale to nie musi chyba być uzytkownik systemu??
    
//    private Set<Contact> contacts;
    private Set<Beneficiary> beneficiaries;

    private Set<Task> tasks; //ktore moga byc wybierane z aktywności, badz mogą być tworzone nowe customowe

//2.12. Dostępu do listy zadań, beneficjentów, Kadry w
// “Opisie projektu” - połączenie z sekcją Lista osób
// wpisana w projekty oraz Zadania i realizacja zadań.


    public Project() {
    }

    public Project(String name, String description, LocalDate startDate, LocalDate endDate, ProjectStatus status, Set<Contractor> contractors, Set<Beneficiary> beneficiaries, Set<Task> tasks) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.contractors = contractors;
        this.beneficiaries = beneficiaries;
        this.tasks = tasks;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Set<Contractor> getContractors() {
        return contractors;
    }

    public void setContractors(Set<Contractor> contractors) {
        this.contractors = contractors;
    }

    public Set<Beneficiary> getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(Set<Beneficiary> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
