package pl.com.britenet.kta.entity.projekt;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.notatka.Notatka;

import java.util.Date;
import java.util.Set;

public class Zadanie extends BaseEntity {

    private String tytul;
    private String opis;

    private Set<Object> osoby; //kto to? osoby wybierane z kadry

    private Date dataUtworzenia;
    private Date dataZakonczenia;
    private Date dataRozpoczecia;
    private Date dataRealizacji;
    private ZadanieStatus status;

    private Notatka notatka;

    private Projekt projekt;
}
