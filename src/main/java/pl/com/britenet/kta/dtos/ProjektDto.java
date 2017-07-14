package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.exceptions.BadRequestException;

/**
 * Created by Britenet on 2017-07-13.
 */
public class ProjektDto {

    private String nazwa;
    private String opis;
    private String dataUtworzenia;
    private String dataZamkniecia;

    public ProjektDto() {
    }

    public ProjektDto(String nazwa, String opis, String dataUtworzenia, String dataZamkniecia) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.dataUtworzenia = dataUtworzenia;
        this.dataZamkniecia = dataZamkniecia;
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

    public String getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(String dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    public String getDataZamkniecia() {
        return dataZamkniecia;
    }

    public void setDataZamkniecia(String dataZamkniecia) {
        this.dataZamkniecia = dataZamkniecia;
    }

    public void validate(){
        if (nazwa == null || nazwa.trim().isEmpty())
            throw new BadRequestException("Nazwa nie moze byc pusta");
        if (opis == null || opis.trim().isEmpty())
            throw new BadRequestException("Opis nie moze byc pusty");
        if(!dataUtworzenia.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
            throw new BadRequestException("Niepoprawna data utworzenia");
        if(!dataZamkniecia.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
            throw new BadRequestException("Niepoprawna data zamkniecia");
    }
}
