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
import pl.com.britenet.kta.dtos.ContractorDto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ContractorsControllerApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String appPath = "http://localhost:8080/";

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void getAllContractors() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        RequestEntity requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "contractors"));
        ResponseEntity<List<ContractorDto>> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<ContractorDto>>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void createContractor() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        ContractorDto contractorDto = new ContractorDto("TERAPEUTA", "Imie", "Nazwisko", "Adres", "email@mail.com", "123321123");
        RequestEntity requestEntity = new RequestEntity<>(contractorDto, httpHeaders, HttpMethod.POST, new URI(appPath + "contractors"));
        ResponseEntity<ContractorDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ContractorDto contractorDtoFromDb = responseEntity.getBody();
        assertNotNull(contractorDtoFromDb.getId());
        assertEquals(contractorDto.getFirstName(), contractorDtoFromDb.getFirstName());
        assertEquals(contractorDto.getLastName(), contractorDtoFromDb.getLastName());
        assertEquals(contractorDto.getAddress(), contractorDtoFromDb.getAddress());
        assertEquals(contractorDto.getEmail(), contractorDtoFromDb.getEmail());
        assertEquals(contractorDto.getPhoneNumber(), contractorDtoFromDb.getPhoneNumber());
        assertEquals(contractorDto.getContractorType(), contractorDtoFromDb.getContractorType());
    }

    @Test
    public void getContractorById() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        ContractorDto contractorDto = new ContractorDto("TERAPEUTA", "Imie", "Nazwisko", "Adres", "email@mail.com", "123321123");
        RequestEntity requestEntity = new RequestEntity<>(contractorDto, httpHeaders, HttpMethod.POST, new URI(appPath + "contractors"));
        ResponseEntity<ContractorDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
        String contractorDtoId = responseEntity.getBody().getId();

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "contractors/" + contractorDtoId));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        ContractorDto contractorDtoFromDb = responseEntity.getBody();
        assertEquals(contractorDtoId, contractorDtoFromDb.getId());
        assertEquals(contractorDto.getFirstName(), contractorDtoFromDb.getFirstName());
        assertEquals(contractorDto.getLastName(), contractorDtoFromDb.getLastName());
        assertEquals(contractorDto.getAddress(), contractorDtoFromDb.getAddress());
        assertEquals(contractorDto.getEmail(), contractorDtoFromDb.getEmail());
        assertEquals(contractorDto.getPhoneNumber(), contractorDtoFromDb.getPhoneNumber());
        assertEquals(contractorDto.getContractorType(), contractorDtoFromDb.getContractorType());
    }

    @Test
    public void updateContractor() throws URISyntaxException{
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        ContractorDto contractorDto = new ContractorDto("TERAPEUTA", "Imie", "Nazwisko", "Adres", "email@mail.com", "123321123");
        RequestEntity requestEntity = new RequestEntity<>(contractorDto, httpHeaders, HttpMethod.POST, new URI(appPath + "contractors"));
        ResponseEntity<ContractorDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
        String contractorDtoId = responseEntity.getBody().getId();

        ContractorDto newContractorDto = new ContractorDto("TERAPEUTA", "Imie", "Nazwisko", "Adres", "email@mail.com", "123321123");
        requestEntity = new RequestEntity<>(newContractorDto, httpHeaders, HttpMethod.PUT, new URI(appPath + "contractors/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });

        ContractorDto contractorDtoFromDb = responseEntity.getBody();
        assertEquals(contractorDtoId, contractorDtoFromDb.getId());
        assertEquals(newContractorDto.getFirstName(), contractorDtoFromDb.getFirstName());
        assertEquals(newContractorDto.getLastName(), contractorDtoFromDb.getLastName());
        assertEquals(newContractorDto.getAddress(), contractorDtoFromDb.getAddress());
        assertEquals(newContractorDto.getEmail(), contractorDtoFromDb.getEmail());
        assertEquals(newContractorDto.getPhoneNumber(), contractorDtoFromDb.getPhoneNumber());
        assertEquals(newContractorDto.getContractorType(), contractorDtoFromDb.getContractorType());
    }

    @Test
    public void deleteContractor() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        ContractorDto contractorDto = new ContractorDto("TERAPEUTA", "Imie", "Nazwisko", "Adres", "email@mail.com", "123321123");
        RequestEntity requestEntity = new RequestEntity<>(contractorDto, httpHeaders, HttpMethod.POST, new URI(appPath + "contractors"));
        ResponseEntity<ContractorDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.DELETE, new URI(appPath + "contractors/" + responseEntity.getBody().getId()));
        responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void throwExceptionWhenContractorDoesNotFound() throws URISyntaxException {
        HttpHeaders httpHeaders = TestUtils.httpHeaders();
        exception.expect(HttpServerErrorException.class);

        RequestEntity requestEntity = new RequestEntity<>(httpHeaders, HttpMethod.GET, new URI(appPath + "contractors/" + "incorrectId"));
        ResponseEntity<ContractorDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ContractorDto>() {
        });

    }

}
