package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Address {

    @Id
    private String id;

    private String ulica;
    private String miasto;

    public Address(String ulica, String miasto) {
        this.ulica = ulica;
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ulica='" + ulica + '\'' +
                ", miasto='" + miasto + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
