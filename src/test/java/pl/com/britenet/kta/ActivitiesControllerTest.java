package pl.com.britenet.kta;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.entity.activities.Activity;
import pl.com.britenet.kta.repositories.ActivitiesRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = KtaApplication.class)
//@WebIntegrationTest
@SpringBootTest(classes = KtaApplication.class, webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ActivitiesControllerTest {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private ActivitiesRepository activitiesRepository;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testCreateActivationApi() throws JsonProcessingException {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("title", "aktywnosc1");
        requestBody.put("description", "opis aktywnosci");
        requestBody.put("activityDictionary", "zajecia");
        String[] strings = {"Jan Kowalski"};
        requestBody.put("contractors", strings);
        requestBody.put("endDate", "2017-07-07");
        requestBody.put("amountOfTime", 90);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity =
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);
        Map<String, Object> apiResponse =
                restTemplate.postForObject("http://localhost:8888/activities", httpEntity, Map.class, Collections.EMPTY_MAP);
        assertNotNull(apiResponse);

        String activityId = ((Map<String, Object>)apiResponse.get("book")).get("id").toString();
        assertNotNull(activityId);

        Activity activityFromDb = activitiesRepository.findOne(activityId);
        assertEquals("aktywnosc1", activityFromDb.getTitle());
        assertEquals("opis aktywnosci", activityFromDb.getDescription());
        assertEquals("zajecia", activityFromDb.getActivityDictionary());



    }


}
