package pl.com.britenet.kta.entity.projekt;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.crm.Beneficjent;
import pl.com.britenet.kta.entity.notatka.Notatka;
import pl.com.britenet.kta.entity.user.User;

import java.util.Date;
import java.util.Set;

//podobne do jiry
public class Projekt extends BaseEntity {

    private String nazwa;
    private String opis;

    private Date dataOtwarcia;
    private Date dataZamkniecia;

    private ProjektStatus status;
    private Notatka notatka;

    private Set<User> kadra; //terapeuta lub wolontariusz - no ale to nie musi chyba być uzytkownik systemu??
    private Set<Beneficjent> beneficjenci; //czy to kontakty?? osoby ktorym się pomaga - ludzie z autyzmem badz  rodziny

    private Set<Zadanie> zadania; //ktore moga byc wybierane z aktywności, badz mogą być tworzone nowe customowe

//2.12. Dostępu do listy zadań, beneficjentów, Kadry w
// “Opisie projektu” - połączenie z sekcją Lista osób
// wpisana w projekty oraz Zadania i realizacja zadań.
}
