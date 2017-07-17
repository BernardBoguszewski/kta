package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.exceptions.BadRequestException;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-14.
 */
public class UchwalaDto {

    private String tytul;
    private String opis;
    private String numer;
    private String dataUchwalenia;

    public UchwalaDto() {
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNumer() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer = numer;
    }

    public String getDataUchwalenia() {
        return dataUchwalenia;
    }

    public void setDataUchwalenia(String dataUchwalenia) {
        this.dataUchwalenia = dataUchwalenia;
    }

    public void validate() {
        if (tytul == null || tytul.trim().isEmpty())
            throw new BadRequestException("Tytul nie moze byc pusty");
        if (opis == null || opis.trim().isEmpty())
            throw new BadRequestException("Opis nie moze byc pusty");
        if (numer == null || numer.trim().isEmpty())
            throw new BadRequestException("Numer nie moze byc pusty");
        if (!dataUchwalenia.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
            throw new BadRequestException("Niepoprawna data uchwalenia");
    }
}
