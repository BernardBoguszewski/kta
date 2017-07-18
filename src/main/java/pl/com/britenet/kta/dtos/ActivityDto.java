package pl.com.britenet.kta.dtos;

import pl.com.britenet.kta.entity.activities.ActivityDictionary;
import pl.com.britenet.kta.exceptions.BadRequestException;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Britenet on 2017-07-18.
 */
public class ActivityDto {

    private String title;
    private String description;
    private String activityDictionary;
    private Set<String> contractors;
    private String  endDate;
    private int amountOfTime;

    public ActivityDto() {
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
