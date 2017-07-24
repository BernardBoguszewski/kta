package pl.com.britenet.kta;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.com.britenet.kta.dtos.BeneficiaryDto;
import pl.com.britenet.kta.entity.project.Beneficiary;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BeneficiaryControllerApiTest {

    private RestTemplate restTemplate = new RestTemplate();
    private String appPath = "http://localhost:8080/";

    @Test
    public void getAllBeneficiaries() throws URISyntaxException{
        RequestEntity requestEntity = new RequestEntity<>(TestUtils.httpHeaders(), HttpMethod.GET, new URI(appPath + "beneficiaries"));
        ResponseEntity<List<Beneficiary>> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<Beneficiary>>() {
        });

        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void createBeneficiary() throws URISyntaxException{
        BeneficiaryDto beneficiaryDto = new BeneficiaryDto("OTOCZENIE", "John", "Porter", "adres", "email@mail.com", "123456789", 90);
        RequestEntity requestEntity = new RequestEntity<>(beneficiaryDto, TestUtils.httpHeaders(), HttpMethod.POST, new URI(appPath + "beneficiaries"));
        ResponseEntity<BeneficiaryDto> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<BeneficiaryDto>() {
        });
        assertEquals(200, responseEntity.getStatusCodeValue());

        BeneficiaryDto beneficiaryDtoFromDb = responseEntity.getBody();
        assertNotNull(beneficiaryDtoFromDb.getId());
        assertEquals(beneficiaryDto.getFirstName(), beneficiaryDtoFromDb.getFirstName());
        assertEquals(beneficiaryDto.getLastName(), beneficiaryDtoFromDb.getLastName());
        assertEquals(beneficiaryDto.getAddress(), beneficiaryDtoFromDb.getAddress());
        assertEquals(beneficiaryDto.getBeneficiaryType(), beneficiaryDtoFromDb.getBeneficiaryType());
        assertEquals(beneficiaryDto.getHoursOfSupport(), beneficiaryDtoFromDb.getHoursOfSupport());
    }
}
