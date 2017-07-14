package pl.com.britenet.kta;

import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.entity.user.Role;
import pl.com.britenet.kta.entity.user.RoleType;
import pl.com.britenet.kta.entity.user.User;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Optional;

public class UserControllerApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String appPath = "http://localhost:8080/";

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
    public void getAllUsers() throws URISyntaxException {
        HttpHeaders httpHeaders = getHttpHeaders();
        RequestEntity requestEntity = new RequestEntity(httpHeaders, HttpMethod.GET, new URI(appPath + "users"));
        ResponseEntity<List<User>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<User>>() {
        });
        List<User> body = exchange.getBody();
        body.forEach(System.out::println);
    }

    @Test
    public void addUser() throws URISyntaxException {
        HttpHeaders httpHeaders =  getHttpHeaders();

        RequestEntity requestEntity = new RequestEntity(httpHeaders, HttpMethod.GET, new URI(appPath + "roles"));
        ResponseEntity<List<Role>> roles = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Role>>() {
        });
        roles.getBody().forEach(System.out::println);

        Optional<Role> first = roles.getBody().stream().filter(role -> RoleType.ADMINISTRATOR.equals(role.getRoleType())).findFirst();
        User user = User.builder().login("login123").email("email123@com.pl").role(first.orElse(null)).build();
        requestEntity = new RequestEntity<>(user, httpHeaders, HttpMethod.POST, new URI(appPath + "users"));
        ResponseEntity<User> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<User>() {
        });
        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "users/" + exchange.getBody().getId()));
        exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<User>() {
        });
        User body = exchange.getBody();
        System.out.println(body);

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "roles/" + body.getRole().getId()));
        ResponseEntity<Role> rola = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Role>() {
        });
        System.out.println(rola.getBody());
    }

    @Test
    public void addUser1() throws URISyntaxException {
        HttpHeaders httpHeaders =  getHttpHeaders();

        Role role = new Role();
//        role.setId("5968b047af855c3ac37ac73a");
        role.setRoleType(RoleType.KSIEGOWA);

        User user = User.builder().login("login123").email("email123@com.pl").role(role).build();
        RequestEntity<User> requestEntity = new RequestEntity<>(user, httpHeaders, HttpMethod.POST, new URI(appPath + "users"));
        ResponseEntity<User> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<User>() {
        });
        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "users/" + exchange.getBody().getId()));
        exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<User>() {
        });
        User body = exchange.getBody();
        System.out.println(body);

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "roles/" + body.getRole().getId()));
        ResponseEntity<Role> rola = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<Role>() {
        });
        System.out.println(rola.getBody());
    }
}
