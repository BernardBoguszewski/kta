package pl.com.britenet.kta.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.britenet.kta.builders.ActivityBuilder;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ActivitiesRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActivitiesServiceTest {

    @Mock
    private ActivitiesRepository activitiesRepository;

    @Mock
    private Activity activity;

    @Mock
    private ActivityBuilder activityBuilder;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private ActivitiesService activitiesService;

    private ActivityDto activityDto;

    @Before
    public void setUp() {
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        activityDto = new ActivityDto("title", "desc", "zajecia", contractors, "2017-07-07", 90);
        activitiesService = new ActivitiesService(activitiesRepository, activityBuilder);
    }

    @Test
    public void shouldCreateActivity() {
        when(activityBuilder.create(activityDto)).thenReturn(activity);

        ActivityDto dtoToReturn = activitiesService.createActivity(activityDto);

        assertEquals(activityDto.getTitle(), dtoToReturn.getTitle());
        assertEquals(activityDto.getDescription(), dtoToReturn.getDescription());
        assertEquals(activityDto.getEndDate(), dtoToReturn.getEndDate());
    }

    @Test
    public void shouldThrowExceptionWhenActivityDoesNotExist() {
        String badId = "bad id";
        exception.expect(BadRequestException.class);
        when(activitiesRepository.findOne(badId)).thenReturn(null);

        activitiesService.getActivity(badId);
    }

    @Test
    public void shouldDeleteActivityIfExist(){
        String correctId = "id";
        when(activitiesRepository.findOne(correctId)).thenReturn(activity);

        activitiesService.deleteActivity(correctId);

        verify(activitiesRepository).delete(correctId);
    }

}
