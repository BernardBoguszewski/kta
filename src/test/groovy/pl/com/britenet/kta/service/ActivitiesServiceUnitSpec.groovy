package pl.com.britenet.kta.service

import pl.com.britenet.kta.builders.ActivityBuilder
import pl.com.britenet.kta.dtos.ActivityDto
import pl.com.britenet.kta.entity.activities.Activity
import pl.com.britenet.kta.repositories.ActivitiesRepository
import pl.com.britenet.kta.services.ActivitiesService
import pl.com.britenet.kta.services.ActivitiesServiceTest
import spock.lang.Specification

class ActivitiesServiceUnitSpec extends Specification{

    ActivitiesRepository activitiesRepository = Mock(ActivitiesRepository)
    ActivityBuilder activityBuilder = new ActivityBuilder()
    ActivitiesService activitiesService = new ActivitiesService(activitiesRepository, activityBuilder)

    def "should create user"(){
        given:
        Set<String> set = new HashSet<>();
        set.add("Jan Kowalski");
        def activityDto = new ActivityDto("title", "desc", "zajecia", set, "2017-07-07", 90)

        when:
        Activity activity = activitiesService.createActivity(activityDto)

        then:
        1 * activitiesRepository.save(activity)
        activity
    }
}
