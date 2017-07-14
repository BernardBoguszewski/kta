package pl.com.britenet.kta.entity.czlonkostwo;

import pl.com.britenet.kta.entity.Adres;
import pl.com.britenet.kta.entity.BaseEntity;

import java.util.Date;

public class WplataSkladki extends BaseEntity {

//    private String nazwa; //członek to nie tylko osoba, ale np. firma lub instytucja, więc to pole musi mieć bardziej ogólną nazwę z możliwością dodatkowego wyboru: Imię, Nazwisko, w przypadku osoby. W przypadku firmy dane jak NIP i  REGON
//    private Adres adres;
//    private String email;
//    private String telefon;
    private CzlonekStowarzyszenia wplacajacy;

    private Date dataWplaty;
    private Skladka skladka;
    private String opis;
}
