package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.dtos.BeneficiaryDto;
import pl.com.britenet.kta.entity.project.Beneficiary;
import pl.com.britenet.kta.entity.project.BeneficiaryType;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.BeneficiaryRepository;

import java.util.List;

@Service
public class BeneficiaryService {

    private BeneficiaryRepository beneficiaryRepository;

    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    @Transactional
    public BeneficiaryDto createBeneficiary(BeneficiaryDto beneficiaryDto) {
        Beneficiary beneficiary = new Beneficiary(BeneficiaryType.valueOf(beneficiaryDto.getBeneficiaryType()),
                beneficiaryDto.getFirstName(), beneficiaryDto.getLastName(), beneficiaryDto.getAddress(),
                beneficiaryDto.getEmail(), beneficiaryDto.getPhoneNumber(), beneficiaryDto.getHoursOfSupport());
        return mapToDto(beneficiaryRepository.save(beneficiary));
    }

    private BeneficiaryDto mapToDto(Beneficiary beneficiaryFromDb) {
        return new BeneficiaryDto(beneficiaryFromDb.getId(), beneficiaryFromDb.getBeneficiaryType().toString(), beneficiaryFromDb.getFirstName(), beneficiaryFromDb.getLastName(),
                beneficiaryFromDb.getAddress(), beneficiaryFromDb.getEmail(), beneficiaryFromDb.getPhoneNumber(), beneficiaryFromDb.getHoursOfSupport());
    }

    @Transactional
    public List<Beneficiary> listAll() {
        return beneficiaryRepository.findAll();
    }

    @Transactional
    public Beneficiary getBeneficiary(String id) {
        Beneficiary beneficiary = beneficiaryRepository.findOne(id);
        if (beneficiary == null)
            throw new BadRequestException("beneficiary not found");
        return beneficiary;
    }

    @Transactional
    public BeneficiaryDto updateBeneficiary(String id, BeneficiaryDto beneficiaryDto) {
        Beneficiary beneficiary = beneficiaryRepository.findOne(id);
        if (beneficiary == null)
            throw new BadRequestException("beneficiary not found");
        beneficiary.setBeneficiaryType(BeneficiaryType.valueOf(beneficiaryDto.getBeneficiaryType()));
        beneficiary.setFirstName(beneficiaryDto.getFirstName());
        beneficiary.setLastName(beneficiaryDto.getLastName());
        beneficiary.setAddress(beneficiaryDto.getAddress());
        beneficiary.setEmail(beneficiaryDto.getEmail());
        beneficiary.setPhoneNumber(beneficiaryDto.getPhoneNumber());
        beneficiary.setHoursOfSupport(beneficiaryDto.getHoursOfSupport());
        return mapToDto(beneficiaryRepository.save(beneficiary));
    }

    @Transactional
    public void deleteBeneficiary(String id) {
        Beneficiary beneficiary = beneficiaryRepository.findOne(id);
        if (beneficiary == null)
            throw new BadRequestException("beneficiary not found");
        beneficiaryRepository.delete(id);
    }
}
