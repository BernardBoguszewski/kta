package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.enums.StatusZadania;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Zadanie {

    @Id
    private String id;

    private String tytul;
    private String opis;
    private Set<User> osobyPrzypisane; // TODO: 2017-07-13 kto jest przypisany do zadania?
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private LocalDate dataRealizacji;
    private StatusZadania statusZadania;
    private Notatka notatka;
}
