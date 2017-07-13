package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;
import pl.com.britenet.kta.enums.StatusProjektu;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Projekt {

    @Id
    private String id;

    private String nazwa;
    private String opis;
    private LocalDate dataUtworzenia;
    private LocalDate dataZamkniecia;
    private StatusProjektu statusProjektu;
    private Notatka notatka;

    public Projekt() {
    }

    public Projekt(String nazwa, String opis, LocalDate dataUtworzenia, LocalDate dataZamkniecia) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataUtworzenia = dataUtworzenia;
        this.dataZamkniecia = dataZamkniecia;
    }

    public Projekt(String nazwa, String opis, LocalDate dataUtworzenia, LocalDate dataZamkniecia, StatusProjektu statusProjektu, Notatka notatka) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataUtworzenia = dataUtworzenia;
        this.dataZamkniecia = dataZamkniecia;
        this.statusProjektu = statusProjektu;
        this.notatka = notatka;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalDate getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(LocalDate dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public LocalDate getDataZamkniecia() {
        return dataZamkniecia;
    }

    public void setDataZamkniecia(LocalDate dataZamkniecia) {
        this.dataZamkniecia = dataZamkniecia;
    }

    public StatusProjektu getStatusProjektu() {
        return statusProjektu;
    }

    public void setStatusProjektu(StatusProjektu statusProjektu) {
        this.statusProjektu = statusProjektu;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }
}
