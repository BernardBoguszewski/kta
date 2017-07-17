package pl.com.britenet.kta.domain;

import pl.com.britenet.kta.enums.RodzajBeneficjenta;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Beneficjent extends Contact {


    private LocalDate birthDate;
    private Boolean disabled;
    private LocalDate dataWystawieniaZaswiadczenia;
    private LocalDate dataWaznosciZaswiadczenia;
    private  Notatka notatka;
    private RodzajBeneficjenta rodzajBeneficjenta;

    public Beneficjent(LocalDate birthDate, Boolean disabled, LocalDate dataWystawieniaZaswiadczenia, LocalDate dataWaznosciZaswiadczenia, Notatka notatka) {
        this.birthDate = birthDate;
        this.disabled = disabled;
        this.dataWystawieniaZaswiadczenia = dataWystawieniaZaswiadczenia;
        this.dataWaznosciZaswiadczenia = dataWaznosciZaswiadczenia;
        this.notatka = notatka;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDate getDataWystawieniaZaswiadczenia() {
        return dataWystawieniaZaswiadczenia;
    }

    public void setDataWystawieniaZaswiadczenia(LocalDate dataWystawieniaZaswiadczenia) {
        this.dataWystawieniaZaswiadczenia = dataWystawieniaZaswiadczenia;
    }

    public LocalDate getDataWaznosciZaswiadczenia() {
        return dataWaznosciZaswiadczenia;
    }

    public void setDataWaznosciZaswiadczenia(LocalDate dataWaznosciZaswiadczenia) {
        this.dataWaznosciZaswiadczenia = dataWaznosciZaswiadczenia;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }
}
