package pl.com.britenet.kta.entity.crm;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;
import pl.com.britenet.kta.entity.project.Project;

import java.util.Set;

public class Beneficiary extends Contact {



    private String birthDate;

    private boolean disabled; //niepelnosprawny
    private String releaseDate; // dataWystawieniaZaswiadczenia
    private String expirationDate; //dataWaznosciZaswiadczenia

//    //Otoczenie - z sekcji 1.1.10. Lista osób wpisana w projekty
//    private boolean parent;
//    private boolean siblings;

    // z sekcji 1.1.10. Lista osób wpisana w projekty
//2.3. Nazwa projektu (możliwość wpisania więcej niż jednego)
    private Set<Project> projects;
    private int hoursOfSupport; //liczbaGodzinUdzielonegoWsparcia
    private String year; ///rok ???
    //private Note note;
}
