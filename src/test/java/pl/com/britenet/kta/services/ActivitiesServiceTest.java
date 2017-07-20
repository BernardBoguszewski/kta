package pl.com.britenet.kta.services;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.britenet.kta.builders.ActivityBuilder;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.repositories.ActivitiesRepository;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ActivitiesServiceTest {

    @Mock
    private ActivitiesRepository activitiesRepository;


    private ActivityBuilder activityBuilder = new ActivityBuilder();


    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ActivitiesService activitiesService = new ActivitiesService(activitiesRepository, activityBuilder);

    @Test
    public void shouldCreateActivity() {
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        ActivityDto activityDto = new ActivityDto("title", "desc", "zajecia", contractors, "2017-07-07", 90);

        Activity activity = activityBuilder.create(activityDto);
        activitiesService.createActivity(activityDto);

        verify(activitiesRepository).save(activity);
    }

    @Test
    public void shouldThrowExceptionWhenActivityDoesNotExist(){

    }
}
