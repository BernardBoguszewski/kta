package pl.com.britenet.kta;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.dtos.ClientDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientsControllerApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String appPath = "http://localhost:8080/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getAllClients() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        RequestEntity requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "clients"));
        ResponseEntity<List<ClientDto>> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<ClientDto>>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void createClient() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();

        ClientDto clientDto = new ClientDto("nazwa", "adres", "email@mail.com", "123123123", "FIRMA");
        RequestEntity requestEntity = new RequestEntity<>(clientDto, httpHeaders, HttpMethod.POST, new URI(appPath + "clients"));
        ResponseEntity<ClientDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ClientDto clientDtoFromDb = responseEntity.getBody();
        assertNotNull(clientDtoFromDb.getId());
        assertEquals(clientDto.getName(), clientDtoFromDb.getName());
        assertEquals(clientDto.getEmail(), clientDtoFromDb.getEmail());
        assertEquals(clientDto.getAddress(), clientDtoFromDb.getAddress());
        assertEquals(clientDto.getPhoneNumber(), clientDtoFromDb.getPhoneNumber());
        assertEquals(clientDto.getContactType(), clientDtoFromDb.getContactType());
    }

    @Test
    public void getClientById() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();

        ClientDto clientDto = new ClientDto("nazwa", "adres", "email@mail.com", "123123123", "FIRMA");
        RequestEntity requestEntity = new RequestEntity<>(clientDto, httpHeaders, HttpMethod.POST, new URI(appPath + "clients"));
        ResponseEntity<ClientDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
        String clientDtoId = responseEntity.getBody().getId();

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "clients/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });

        ClientDto clientDtoFromDb = responseEntity.getBody();
        assertEquals(clientDtoId, clientDtoFromDb.getId());
        assertEquals(clientDto.getName(), clientDtoFromDb.getName());
        assertEquals(clientDto.getEmail(), clientDtoFromDb.getEmail());
        assertEquals(clientDto.getAddress(), clientDtoFromDb.getAddress());
        assertEquals(clientDto.getPhoneNumber(), clientDtoFromDb.getPhoneNumber());
        assertEquals(clientDto.getContactType(), clientDtoFromDb.getContactType());
    }

    @Test
    public void updateClient() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();

        ClientDto clientDto = new ClientDto("nazwa", "adres", "email@mail.com", "123123123", "FIRMA");
        RequestEntity requestEntity = new RequestEntity<>(clientDto, httpHeaders, HttpMethod.POST, new URI(appPath + "clients"));
        ResponseEntity<ClientDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
        String clientDtoId = responseEntity.getBody().getId();

        ClientDto newClientDto = new ClientDto("inna nazwa", "inny adres", "email2@mail.com", "123123333", "ORGANIZACJA");
        requestEntity = new RequestEntity<>(newClientDto, httpHeaders, HttpMethod.PUT, new URI(appPath + "clients/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ClientDto updatedClientDto = responseEntity.getBody();
        assertEquals(clientDtoId, updatedClientDto.getId());
        assertEquals(newClientDto.getName(), updatedClientDto.getName());
        assertEquals(newClientDto.getEmail(), updatedClientDto.getEmail());
        assertEquals(newClientDto.getAddress(), updatedClientDto.getAddress());
        assertEquals(newClientDto.getPhoneNumber(), updatedClientDto.getPhoneNumber());
        assertEquals(newClientDto.getContactType(), updatedClientDto.getContactType());

    }

    @Test
    public void deleteClient() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();

        ClientDto clientDto = new ClientDto("nazwa", "adres", "email@mail.com", "123123123", "FIRMA");
        RequestEntity requestEntity = new RequestEntity<>(clientDto, httpHeaders, HttpMethod.POST, new URI(appPath + "clients"));
        ResponseEntity<ClientDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.DELETE, new URI(appPath + "clients/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void throwExceptionIfClientDoesNotExist() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        exception.expect(HttpServerErrorException.class);

        RequestEntity requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.DELETE, new URI(appPath + "clients/" + "incorrectId"));
        ResponseEntity<ClientDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ClientDto>() {
        });
    }

}
