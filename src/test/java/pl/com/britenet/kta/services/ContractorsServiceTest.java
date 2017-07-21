package pl.com.britenet.kta.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.britenet.kta.dtos.ContractorDto;
import pl.com.britenet.kta.entity.project.Contractor;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ContractorsRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContractorsServiceTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private ContractorsRepository contractorsRepository;

    @Mock
    private Contractor contractor;

    private ContractorDto contractorDto;
    private ContractorsService contractorsService;

    private String goodId = "good id";
    private String badId = "bad id";

    @Before
    public void setUp() {
        contractorDto = new ContractorDto("TERAPEUTA", "Tero", "Mero", "Adresso", "tm@mail.com", "123141123");
        contractorsService = new ContractorsService(contractorsRepository);
    }

    @Test
    public void shouldCreateContractor() {

        contractorsService.createContractor(contractorDto);

        verify(contractorsRepository).save(any(Contractor.class));
    }

    @Test
    public void shouldThrowExceptionIfContractorNotExist() {
        exception.expect(BadRequestException.class);
        when(contractorsRepository.findOne(badId)).thenReturn(null);

        contractorsService.getContractor(badId);
    }

    @Test
    public void shouldGetContractorIfExist() {
        when(contractorsRepository.findOne(goodId)).thenReturn(contractor);

        Contractor contractorFromDb = contractorsService.getContractor(goodId);

        assertEquals(contractorFromDb, contractor);
        assertEquals(contractorFromDb.getId(), contractor.getId());
    }

    @Test
    public void shouldGetContractors() {
        contractorsService.listAll();

        verify(contractorsRepository).findAll();
    }

    @Test
    public void shouldDeleteContractor() {
        when(contractorsRepository.findOne(goodId)).thenReturn(contractor);

        contractorsService.deleteContractor(goodId);

        verify(contractorsRepository).delete(goodId);
    }

    @Test
    public void shouldUpdateContractor() {
        when(contractorsRepository.findOne(goodId)).thenReturn(contractor);

        contractorsService.updateContractor(goodId, contractorDto);

        verify(contractorsRepository).save(contractor);
    }

}
