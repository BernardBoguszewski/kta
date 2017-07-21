package pl.com.britenet.kta.services;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.britenet.kta.dtos.BeneficiaryDto;
import pl.com.britenet.kta.entity.project.Beneficiary;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.BeneficiaryRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BeneficiaryServiceTest {

    @Mock
    private Beneficiary beneficiary;

    @Mock
    private BeneficiaryRepository beneficiaryRepository;

    private BeneficiaryService beneficiaryService;

    private BeneficiaryDto beneficiaryDto;

    private String goodId = "good id";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp(){
        beneficiaryDto = new BeneficiaryDto("OTOCZENIE", "JJ", "BJ", "adres", "mail@com.com", "123123321", 90);
        beneficiaryService = new BeneficiaryService(beneficiaryRepository);
    }

    @Test
    public void shouldCreateBeneficiary(){
        beneficiaryService.createBeneficiary(beneficiaryDto);

        verify(beneficiaryRepository).save(any(Beneficiary.class));
    }

    @Test
    public void shouldThrowExceptionWhenTryToGetNonExistentBeneficiary(){
        expectedException.expect(BadRequestException.class);
        String badId = "bad id";
        when(beneficiaryRepository.findOne(badId)).thenReturn(null);

        beneficiaryService.getBeneficiary(badId);
    }

    @Test
    public void shouldFindAllBeneficiaries(){

        beneficiaryService.listAll();

        verify(beneficiaryRepository).findAll();
    }

    @Test
    public void shouldGetBeneficiaryWhenExist(){

        when(beneficiaryRepository.findOne(goodId)).thenReturn(beneficiary);

        Beneficiary beneficiaryFromDb = beneficiaryService.getBeneficiary(goodId);

        assertEquals(beneficiaryFromDb, beneficiary);
    }

    @Test
    public void shouldDeleteBeneficiaryIfExist(){
        when(beneficiaryRepository.findOne(goodId)).thenReturn(beneficiary);

        beneficiaryService.deleteBeneficiary(goodId);

        verify(beneficiaryRepository).delete(goodId);
    }

}
