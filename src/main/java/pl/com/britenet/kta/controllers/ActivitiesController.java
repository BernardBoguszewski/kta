package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.services.ActivitiesService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    private ActivitiesService activitiesService;

    public ActivitiesController(ActivitiesService activitiesService) {
        this.activitiesService = activitiesService;
    }

    @PostMapping
    public ActivityDto createActivity(@RequestBody ActivityDto activityDto){
        activityDto.validate();
        return activitiesService.createActivity(activityDto);
    }

    @GetMapping
    public List<Activity> getActivities(){
        return activitiesService.getActivities();
    }

    @GetMapping("/{id}")
    public ActivityDto getActivity(@PathVariable String id){
        return activitiesService.getActivity(id);
    }

    @PutMapping("/{id}")
    public ActivityDto updateActivity(@PathVariable String id, @RequestBody ActivityDto activityDto){
        activityDto.validate();
        return activitiesService.updateActivity(id, activityDto);
    }

    @DeleteMapping("/{id}")
    public void deleteActivity(@PathVariable String id){
        activitiesService.deleteActivity(id);
    }
}
