package pl.com.britenet.kta.entity.donation;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.entity.note.Note;

import java.util.Date;

public class Donation {

    @Id
    private String id;
//    1.1. Nazwa darczyńcy - możliwość pobrania danych z
// CRM (Account, Contact) lub z Lista członków stowarzyszenia,
// dane adresowe. Wybranie Członka lub Kontaktu lub Konta w
// ypełnia nam pole Nazwa darczyńcy. Jeśli nie wybierzemy tych
// opcji to trzeba wpisać darczyńcę.
    private Donator donator;

    private String description;
    private Date dateOfPayment;
    private int amount;
    private Note note;

    //Powiązanie listy darowizn z Członkami oraz Kontem i
    // Kontaktem ma na celu możliwe przyszłe dodanie listy
    // darowizn do sekcji Lista członków stowarzyszenia, dane
    // adresowe oraz Baza organizacji, urzędów, firm.
}
