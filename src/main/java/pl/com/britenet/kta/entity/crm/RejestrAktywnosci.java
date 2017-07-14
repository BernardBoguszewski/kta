package pl.com.britenet.kta.entity.crm;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.RodzajAktywnosci;
import pl.com.britenet.kta.entity.notatka.Notatka;

import java.util.Date;
import java.util.Set;

//Sekcja ma prezentować listę aktywności wykonywanych w Stowarzyszeniu, nie będących zajęciami terapeutycznymi, ani aktywnościami związanymi z projektami (np. porada, opinia, zaświadczenie, diagnoza). Sekcja ma pozwolić zrobić zestawienie okresowe aktywności.
//Rejestr aktywności to tylko:
//        Nie-projekty:
//        •	Inne, czyli: porada, opinia, zaświadczenie, diagnoza à te tzw. „inne” potrzebne są do utworzenia ich zestawienia okresowego
public class RejestrAktywnosci extends BaseEntity {

    private String tytul;
    private String opis;

    private RodzajAktywnosci rodzajAktywnosci;
    private Set<Object> osobeRealizujacaZadanie; //TODO kto to? jakaś relacja do czegoś? Wydawało by sie ze do User

    private Date dataIGodzinaRealizacji;
    private int czasPracy; //godziny i minuty
    private Notatka notatka;
}
