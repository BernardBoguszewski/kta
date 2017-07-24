package pl.com.britenet.kta;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.dto.user.UserDto;
import pl.com.britenet.kta.dtos.ActivityDto;
import pl.com.britenet.kta.entity.activities.Activity;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ActivitiesControllerApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String appPath = "http://localhost:8080/";

    private HttpHeaders httpHeaders() {
        return new HttpHeaders() {{
            String auth = "user:password";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("UTF-8")));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }

    @Test
    public void getAllActivities() throws URISyntaxException{
        RequestEntity requestEntity = new RequestEntity(httpHeaders(), HttpMethod.GET, new URI(appPath + "activities"));
        ResponseEntity<List<Activity>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Activity>>() {
        });
        assertEquals(200, exchange.getStatusCode().value());
    }

    @Test
    public void addActivity() throws URISyntaxException {
        HttpHeaders httpHeaders = httpHeaders();
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        ActivityDto activityDto = new ActivityDto("title", "desc", "zajecia", contractors, "2017-07-07", 90);

        RequestEntity requestEntity = new RequestEntity<>(activityDto, httpHeaders, HttpMethod.POST, new URI(appPath + "activities"));
        ResponseEntity<ActivityDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCode().value());

        ActivityDto activityDtoFromDb = responseEntity.getBody();
        assertNotNull(activityDtoFromDb.getId());
        assertEquals(activityDtoFromDb.getTitle(), activityDto.getTitle());
        assertEquals(activityDtoFromDb.getDescription(), activityDto.getDescription());
        assertEquals(activityDtoFromDb.getAmountOfTime(), activityDto.getAmountOfTime());
    }

    @Test
    public void getActivity() throws URISyntaxException {
        HttpHeaders httpHeaders = httpHeaders();
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        ActivityDto newActivityDto = new ActivityDto("tytul", "desc", "zajecia", contractors, "2017-07-07", 90);
        RequestEntity requestEntity = new RequestEntity<>(newActivityDto, httpHeaders, HttpMethod.POST, new URI(appPath + "activities"));
        ResponseEntity<ActivityDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "activities/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ActivityDto activityDto = responseEntity.getBody();
        assertNotNull(activityDto.getId());
        assertEquals(newActivityDto.getTitle(), activityDto.getTitle());
        assertEquals(newActivityDto.getDescription(), activityDto.getDescription());
        assertEquals(newActivityDto.getActivityDictionary(), activityDto.getActivityDictionary());
        assertEquals(newActivityDto.getContractors(), activityDto.getContractors());
        assertEquals(newActivityDto.getAmountOfTime(), activityDto.getAmountOfTime());
        assertEquals(newActivityDto.getEndDate(), activityDto.getEndDate());
    }

    @Test
    public void updateActivity() throws URISyntaxException{
        HttpHeaders httpHeaders = httpHeaders();
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        ActivityDto newActivityDto = new ActivityDto("tytul", "desc", "zajecia", contractors, "2017-07-07", 90);
        RequestEntity requestEntity = new RequestEntity<>(newActivityDto, httpHeaders, HttpMethod.POST, new URI(appPath + "activities"));
        ResponseEntity<ActivityDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ActivityDto updateActivityDto = new ActivityDto("inny tytul", "inny desc", "zajecia inne", contractors, "2017-07-17", 60);
        requestEntity = new RequestEntity<>(updateActivityDto, httpHeaders, HttpMethod.PUT, new URI(appPath + "activities/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ActivityDto activityDto = responseEntity.getBody();
        assertNotNull(activityDto.getId());
        assertEquals(updateActivityDto.getTitle(), activityDto.getTitle());
        assertEquals(updateActivityDto.getDescription(), activityDto.getDescription());
        assertEquals(updateActivityDto.getActivityDictionary(), activityDto.getActivityDictionary());
        assertEquals(updateActivityDto.getContractors(), activityDto.getContractors());
        assertEquals(updateActivityDto.getAmountOfTime(), activityDto.getAmountOfTime());
        assertEquals(updateActivityDto.getEndDate(), activityDto.getEndDate());
    }

    @Test
    public void deleteActivity() throws URISyntaxException{
        HttpHeaders httpHeaders = httpHeaders();
        Set<String> contractors = new HashSet<>();
        contractors.add("Jan Kowalski");
        ActivityDto newActivityDto = new ActivityDto("tytul", "desc", "zajecia", contractors, "2017-07-07", 90);
        RequestEntity requestEntity = new RequestEntity<>(newActivityDto, httpHeaders, HttpMethod.POST, new URI(appPath + "activities"));
        ResponseEntity<ActivityDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.DELETE, new URI(appPath + "activities/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ActivityDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
