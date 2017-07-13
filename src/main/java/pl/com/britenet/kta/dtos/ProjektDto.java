package pl.com.britenet.kta.dtos;

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
        // TODO: 2017-07-13
    }
}
