package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.entity.activities.ActivityDictionary;
import pl.com.britenet.kta.exceptions.BadRequestException;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Britenet on 2017-07-18.
 */
public class ActivityDto {

    private String id;
    private String title;
    private String description;
    private String activityDictionary;
    private Set<String> contractors;
    private String  endDate;
    private int amountOfTime;

    public ActivityDto() {
    }

    public ActivityDto(String title, String description, String activityDictionary, Set<String> contractors, String endDate, int amountOfTime) {
        this.title = title;
        this.description = description;
        this.activityDictionary = activityDictionary;
        this.contractors = contractors;
        this.endDate = endDate;
        this.amountOfTime = amountOfTime;
    }

    public ActivityDto(String id, String title, String description, String activityDictionary, Set<String> contractors, String endDate, int amountOfTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.activityDictionary = activityDictionary;
        this.contractors = contractors;
        this.endDate = endDate;
        this.amountOfTime = amountOfTime;
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

    public String getActivityDictionary() {
        return activityDictionary;
    }

    public void setActivityDictionary(String activityDictionary) {
        this.activityDictionary = activityDictionary;
    }

    public Set<String> getContractors() {
        return contractors;
    }

    public void setContractors(Set<String> contractors) {
        this.contractors = contractors;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getAmountOfTime() {
        return amountOfTime;
    }

    public void setAmountOfTime(int amountOfTime) {
        this.amountOfTime = amountOfTime;
    }

    public void validate(){
        if(title.trim().isEmpty())
            throw new BadRequestException("Title can not be empty");
        if(description.trim().isEmpty())
            throw new BadRequestException("Description can not be empty");
        if(activityDictionary.trim().isEmpty())
            throw new BadRequestException("Activity dictionary can not be empty");
        if(!endDate.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
            throw new BadRequestException("Inproper date format, year-month-day");
        if(amountOfTime < 0)
            throw new BadRequestException("Amount of time cannot be under zero");
    }
}
