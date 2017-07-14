package pl.com.britenet.kta.entity.czlonkostwo;

import pl.com.britenet.kta.entity.Adres;
import pl.com.britenet.kta.entity.notatka.Notatka;
import pl.com.britenet.kta.entity.uchwaly.Uchwala;

import java.util.Date;
import java.util.Set;

public class CzlonekStowarzyszenia {

    private String nazwa;
    private String nip;
    private String regon;

    private Adres adres;
    private String email;
    private String telefon;

    private Date dataRozpoczecia;
    private Date dataZakonczenia;

    private CzlonekStowarzyszeniaStatus status;
    private String rodzaj; //zwyczajny, honorowy, wspierajacy
    private Notatka notatka;

    private Set<WplataSkladki> wplaty;
    private Set<Uchwala> uchwaly;
}
