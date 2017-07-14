package pl.com.britenet.kta.entity.uchwaly;

import pl.com.britenet.kta.entity.BaseEntity;
import pl.com.britenet.kta.entity.czlonkostwo.CzlonekStowarzyszenia;

import java.util.Date;

public class Uchwala extends BaseEntity {

    private String tytul;
    private String opis;
    private String numeracja; //????
    private Date dataUchwalenia;

    private Uchwala powiazanaZ;
    private CzlonekStowarzyszenia ktoWprowadzil; //????
}
