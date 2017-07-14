package pl.com.britenet.kta.entity.crm;

import pl.com.britenet.kta.entity.Adres;
import pl.com.britenet.kta.entity.notatka.Notatka;

import java.util.Set;

public class KlientStowarzyszenia {

    private Adres adres;
    private String email;
    private String phoneNumber;

    private RodzajKontaktu rodzajKontaktu;
    private Notatka notatka;
}
