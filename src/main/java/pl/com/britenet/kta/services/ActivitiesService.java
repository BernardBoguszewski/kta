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
    public void createActivity(ActivityDto activityDto) {
        Activity activity = activityBuilder.create(activityDto);
        activitiesRepository.save(activity);
    }

    @Transactional
    public List<Activity> getActivities() {
        return activitiesRepository.findAll();
    }

    @Transactional
    public Activity getActivity(String id) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity ==  null)
            throw new BadRequestException("activity does not exist");
        else
            return activity;
    }

    @Transactional
    public void updateActivity(String id, ActivityDto activityDto) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity == null)
            throw new BadRequestException("Activity does not exist");
        ActivityDictionary activityDictionary = new ActivityDictionary(activityDto.getActivityDictionary());
        LocalDate endDate = LocalDate.parse(activityDto.getEndDate());
        activity.setTitle(activityDto.getTitle());
        activity.setDescription(activityDto.getDescription());
        activity.setActivityDictionary(activityDictionary);
        activity.setContractors(activityDto.getContractors());
        activity.setEndDate(endDate);
        activity.setAmountOfTime(activityDto.getAmountOfTime());
        activitiesRepository.save(activity);
    }

    @Transactional
    public void deleteActivity(String id) {
        Activity activity = activitiesRepository.findOne(id);
        if(activity == null)
            throw new BadRequestException("Activity does not exist");
        activitiesRepository.delete(id);
    }

}
