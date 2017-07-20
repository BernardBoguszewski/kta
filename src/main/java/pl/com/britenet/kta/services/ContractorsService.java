package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.dtos.ContractorDto;
import pl.com.britenet.kta.entity.project.Contractor;
import pl.com.britenet.kta.entity.project.ContractorType;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ContractorsRepository;

import java.util.List;

@Service
public class ContractorsService {

    private ContractorsRepository contractorsRepository;

    public ContractorsService(ContractorsRepository contractorsRepository) {
        this.contractorsRepository = contractorsRepository;
    }

    @Transactional
    public void createContractor(ContractorDto contractorDto) {
        Contractor contractor = new Contractor(ContractorType.valueOf(contractorDto.getContractorType()),
                contractorDto.getFirstName(), contractorDto.getLastName(), contractorDto.getAddress(), contractorDto.getEmail(), contractorDto.getPhoneNumber());
        contractorsRepository.save(contractor);
    }

    @Transactional
    public List<Contractor> listAll() {
        return contractorsRepository.findAll();
    }

    @Transactional
    public Contractor getContractor(String id) {
        Contractor contractor = contractorsRepository.findOne(id);
        if (contractor == null)
            throw new BadRequestException("Contractor not found");
        return contractor;
    }

    @Transactional
    public void updateContractor(String id, ContractorDto contractorDto) {
        Contractor contractor = contractorsRepository.findOne(id);
        if (contractor == null)
            throw new BadRequestException("Contractor not found");
        contractor.setContractorType(ContractorType.valueOf(contractorDto.getContractorType()));
        contractor.setFirstName(contractorDto.getFirstName());
        contractor.setLastName(contractorDto.getLastName());
        contractor.setAddress(contractorDto.getAddress());
        contractor.setEmail(contractorDto.getEmail());
        contractorDto.setPhoneNumber(contractorDto.getPhoneNumber());
        contractorsRepository.save(contractor);
    }

    @Transactional
    public void deleteContractor(String id) {
        Contractor contractor = contractorsRepository.findOne(id);
        if (contractor == null)
            throw new BadRequestException("Contractor not found");
        contractorsRepository.delete(id);
    }
}
