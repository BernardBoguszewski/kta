package pl.com.britenet.kta.builders;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.entity.activities.ActivityDictionary;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-18.
 */
@Component
public class ActivityBuilder {

    public static Activity create(ActivityDto activityDto){
        ActivityDictionary activityDictionary = new ActivityDictionary(activityDto.getActivityDictionary());
        LocalDate endDate = LocalDate.parse(activityDto.getEndDate());
        return new Activity(activityDto.getTitle(), activityDto.getDescription(), activityDictionary, activityDto.getContractors(), endDate, activityDto.getAmountOfTime());
    }
}
