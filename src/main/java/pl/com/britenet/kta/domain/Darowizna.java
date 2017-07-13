package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Darowizna {

    @Id
    private String id;

    private Konto konto;
    private String opis;
    private LocalDate dataWplaty;
    private BigDecimal kwota;
    private Notatka notatka;

    public Darowizna() {
    }

    public Darowizna(Konto konto, String opis, LocalDate dataWplaty, BigDecimal kwota, Notatka notatka) {
        this.konto = konto;
        this.opis = opis;
        this.dataWplaty = dataWplaty;
        this.kwota = kwota;
        this.notatka = notatka;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDataWplaty() {
        return dataWplaty;
    }

    public void setDataWplaty(LocalDate dataWplaty) {
        this.dataWplaty = dataWplaty;
    }

    public BigDecimal getKwota() {
        return kwota;
    }

    public void setKwota(BigDecimal kwota) {
        this.kwota = kwota;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }
}
