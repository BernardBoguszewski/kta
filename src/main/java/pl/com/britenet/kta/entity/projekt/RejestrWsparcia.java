package pl.com.britenet.kta.entity.projekt;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.RodzajAktywnosci;
import pl.com.britenet.kta.entity.crm.KlientStowarzyszenia;
import pl.com.britenet.kta.entity.notatka.Notatka;
import pl.com.britenet.kta.entity.projekt.Projekt;

import java.util.Date;
import java.util.Set;

public class RejestrWsparcia extends BaseEntity {

    private RodzajAktywnosci rodzajAktywnosci;
    private String opis;
    private Set<Object> wykonawca; //kto to? User? znow ktoś wpisany z palca
    private Date dataIGodzinaRealizacji;
    private Projekt projekt;//czy zwiazane z projektem

    private Set<KlientStowarzyszenia> uczestnicy; //kto to ?? Klient czy Beneficjent

    private int iloscGodzin; //godziny i minuty
    private Notatka notatka;
}
