package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.builders.ActivityBuilder;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.entity.activities.ActivityDictionary;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ActivitiesRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Britenet on 2017-07-18.
 */
@Service
public class ActivitiesService {

    private ActivitiesRepository activitiesRepository;
    private ActivityBuilder activityBuilder;

    public ActivitiesService(ActivitiesRepository activitiesRepository, ActivityBuilder activityBuilder) {
        this.activitiesRepository = activitiesRepository;
        this.activityBuilder = activityBuilder;
    }

    @Transactional
    public ActivityDto createActivity(ActivityDto activityDto) {
        Activity activity = activityBuilder.create(activityDto);
        return mapToDto(activitiesRepository.save(activity));
    }

    private ActivityDto mapToDto(Activity activity) {
        LocalDate endDate = activity.getEndDate();
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        String endDateInString = endDate.format(formatter);
        return new ActivityDto(activity.getId(), activity.getTitle(), activity.getDescription(),
                activity.getActivityDictionary(), activity.getContractors(),
                endDateInString, activity.getAmountOfTime());
    }

    @Transactional
    public List<Activity> getActivities() {
        return activitiesRepository.findAll();
    }

    @Transactional
    public ActivityDto getActivity(String id) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity ==  null)
            throw new BadRequestException("activity does not exist");
        else
            return mapToDto(activity);
    }

    @Transactional
    public ActivityDto updateActivity(String id, ActivityDto activityDto) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity == null)
            throw new BadRequestException("Activity does not exist");
        LocalDate endDate = LocalDate.parse(activityDto.getEndDate());
        activity.setTitle(activityDto.getTitle());
        activity.setDescription(activityDto.getDescription());
        activity.setActivityDictionary(activityDto.getActivityDictionary());
        activity.setContractors(activityDto.getContractors());
        activity.setEndDate(endDate);
        activity.setAmountOfTime(activityDto.getAmountOfTime());
        return mapToDto(activitiesRepository.save(activity));
    }

    @Transactional
    public void deleteActivity(String id) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity == null)
            throw new BadRequestException("Activity does not exist");
        activitiesRepository.delete(id);
    }

}
