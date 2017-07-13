package pl.com.britenet.kta.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by Britenet on 2017-07-13.
 */
public class Aktywnosc {

    @Id
    private String id;

    private String title;
    private String description;
    private String activityType;
    private String osobaRealizujaca;
    private LocalDateTime dataRealizacji;
    private long duration;
    private Notatka notatka;

    public Aktywnosc(String title, String description, String activityType, String osobaRealizujaca, LocalDateTime dataRealizacji, long duration, Notatka notatka) {
        this.title = title;
        this.description = description;
        this.activityType = activityType;
        this.osobaRealizujaca = osobaRealizujaca;
        this.dataRealizacji = dataRealizacji;
        this.duration = duration;
        this.notatka = notatka;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public String getOsobaRealizujaca() {
        return osobaRealizujaca;
    }

    public void setOsobaRealizujaca(String osobaRealizujaca) {
        this.osobaRealizujaca = osobaRealizujaca;
    }

    public LocalDateTime getDataRealizacji() {
        return dataRealizacji;
    }

    public void setDataRealizacji(LocalDateTime dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Notatka getNotatka() {
        return notatka;
    }

    public void setNotatka(Notatka notatka) {
        this.notatka = notatka;
    }
}
