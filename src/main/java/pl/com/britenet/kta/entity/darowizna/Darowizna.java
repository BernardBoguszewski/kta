package pl.com.britenet.kta.entity.darowizna;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.crm.KlientStowarzyszenia;
import pl.com.britenet.kta.entity.czlonkostwo.CzlonekStowarzyszenia;
import pl.com.britenet.kta.entity.notatka.Notatka;

import java.util.Date;
import java.util.Set;

public class Darowizna extends BaseEntity {

//    1.1. Nazwa darczyńcy - możliwość pobrania danych z
// CRM (Konto, Kontakt) lub z Lista członków stowarzyszenia,
// dane adresowe. Wybranie Członka lub Kontaktu lub Konta w
// ypełnia nam pole Nazwa darczyńcy. Jeśli nie wybierzemy tych
// opcji to trzeba wpisać darczyńcę.
    private Darczynca darczynca;

    private String opis;
    private Date dataWplaty;
    private int kwota;
    private Notatka notatka;

    //Powiązanie listy darowizn z Członkami oraz Kontem i
    // Kontaktem ma na celu możliwe przyszłe dodanie listy
    // darowizn do sekcji Lista członków stowarzyszenia, dane
    // adresowe oraz Baza organizacji, urzędów, firm.
}
