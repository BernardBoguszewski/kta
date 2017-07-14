package pl.com.britenet.kta;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.example.entity.Colleague;
import pl.com.britenet.kta.example.entity.Recognition;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TestApiTest {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void test() throws URISyntaxException {
        HttpHeaders httpHeaders = getHttpHeaders();
        RequestEntity requestEntity = new RequestEntity(httpHeaders, HttpMethod.GET, new URI("http://localhost:8181/colleagues"));
        ResponseEntity<List<Colleague>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Colleague>>() {
        });
        List<Colleague> body = exchange.getBody();
        body.forEach(System.out::println);
    }

    private HttpHeaders getHttpHeaders() {
        return new HttpHeaders() {{
                String auth = "user:password" ;
                byte[] encodedAuth = Base64.encodeBase64(
                        auth.getBytes(Charset.forName("UTF-8")) );
                String authHeader = "Basic " + new String( encodedAuth );
                set( "Authorization", authHeader );
            }};
    }

    @Test
    public void test2() throws URISyntaxException {
        HttpHeaders httpHeaders =  getHttpHeaders();
        Colleague colleague = new Colleague();
        colleague.name = "Test123";
        ArrayList<Recognition> recognitions = new ArrayList<>();
        Recognition recognition = new Recognition();
        recognition.setDescription("description1");
        recognitions.add(recognition);
        colleague.recognitions = recognitions;

        RequestEntity<Colleague> requestEntity = new RequestEntity<Colleague>(colleague, httpHeaders, HttpMethod.POST, new URI("http://localhost:8181/colleagues"));
        ResponseEntity<Colleague> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Colleague>() {
        });
        System.out.println(exchange.getStatusCode());
    }

    @Test
    public void test3() throws URISyntaxException {
        HttpHeaders httpHeaders = getHttpHeaders();
        String name = "Test123";
        RequestEntity requestEntity = new RequestEntity(httpHeaders, HttpMethod.GET, new URI("http://localhost:8181/colleagues/"+name));
        ResponseEntity<List<Colleague>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Colleague>>() {
        });
        List<Colleague> body = exchange.getBody();
        body.forEach(System.out::println);
    }
}
