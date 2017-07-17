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
import pl.com.britenet.kta.dto.user.RoleDto;
import pl.com.britenet.kta.dto.user.UserDto;
import pl.com.britenet.kta.entity.user.RoleType;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;

public class UserControllerApiTest {

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
    public void getAllUsers() throws URISyntaxException {
        RequestEntity requestEntity = new RequestEntity(httpHeaders(), HttpMethod.GET, new URI(appPath + "users"));
        ResponseEntity<List<UserDto>> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<UserDto>>() {
        });
        Assert.assertEquals(200, exchange.getStatusCode().value());
        exchange.getBody().forEach(System.out::println);
    }

    @Test
    public void addUser() throws URISyntaxException {
        HttpHeaders httpHeaders = httpHeaders();
        RoleDto roleDto = getRoleDto(RoleType.ADMINISTRATOR, httpHeaders);

        UserDto newUserDto = UserDto.builder()
                .login("login123")
                .password("password")
                .email("email123@com.pl")
                .phoneNumber("phoneNumber")
                .role(roleDto)
                .build();

        RequestEntity requestEntity = new RequestEntity<>(newUserDto, httpHeaders, HttpMethod.POST, new URI(appPath + "users"));
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<UserDto>() {
        });
        Assert.assertEquals(200, responseEntity.getStatusCode().value());

        UserDto userDto = responseEntity.getBody();
        Assert.assertNotNull(userDto.getId());
        Assert.assertEquals(newUserDto.getLogin(), userDto.getLogin());
        Assert.assertNull(userDto.getPassword());
        Assert.assertEquals(newUserDto.getEmail(), userDto.getEmail());
        Assert.assertEquals(newUserDto.getPhoneNumber(), userDto.getPhoneNumber());
    }

    @Test
    public void getUser() throws URISyntaxException {
        HttpHeaders httpHeaders = httpHeaders();
        RoleDto roleDto = getRoleDto(RoleType.ADMINISTRATOR, httpHeaders);
        UserDto newUserDto = UserDto.builder()
                .login("login123")
                .password("password")
                .email("email123@com.pl")
                .phoneNumber("phoneNumber")
                .role(roleDto)
                .build();

        RequestEntity requestEntity = new RequestEntity<>(newUserDto, httpHeaders, HttpMethod.POST, new URI(appPath + "users"));
        ResponseEntity<UserDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<UserDto>() {
        });
        Assert.assertEquals(200, responseEntity.getStatusCode().value());

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "users/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<UserDto>() {
        });
        Assert.assertEquals(200, responseEntity.getStatusCode().value());

        UserDto userDto = responseEntity.getBody();
        System.out.println(userDto);
        Assert.assertNotNull(userDto.getId());
        Assert.assertEquals(newUserDto.getLogin(), userDto.getLogin());
        Assert.assertNull(userDto.getPassword());
        Assert.assertEquals(newUserDto.getEmail(), userDto.getEmail());
        Assert.assertEquals(newUserDto.getPhoneNumber(), userDto.getPhoneNumber());
    }

    @Test
    public void thrownExceptionDuringAddingUser() throws URISyntaxException {
        HttpHeaders httpHeaders = httpHeaders();
        RoleDto roleDto = RoleDto.builder()
                .id("fakeID")
                .roleType(RoleType.KSIEGOWA)
                .build();
        UserDto user = UserDto.builder()
                .login("login123")
                .email("email123@com.pl")
                .role(roleDto)
                .build();

        RequestEntity<UserDto> requestEntity = new RequestEntity<>(user, httpHeaders, HttpMethod.POST, new URI(appPath + "users"));
        ResponseEntity<UserDto> exchange = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<UserDto>() {
        });
    }

    private RoleDto getRoleDto(RoleType roleType, HttpHeaders httpHeaders) throws URISyntaxException {
        RequestEntity requestEntity = new RequestEntity(httpHeaders, HttpMethod.GET, new URI(appPath + "roles"));
        ResponseEntity<List<RoleDto>> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<RoleDto>>() {
        });

        Assert.assertEquals(200, responseEntity.getStatusCode().value());
        return responseEntity.getBody().stream()
                .filter(role -> roleType.equals(role.getRoleType()))
                .findFirst().orElse(null);
    }
}
