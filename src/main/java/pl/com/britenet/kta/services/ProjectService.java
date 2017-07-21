package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.dtos.ProjectDto;
import pl.com.britenet.kta.entity.project.Beneficiary;
import pl.com.britenet.kta.entity.project.Contractor;
import pl.com.britenet.kta.entity.project.Project;
import pl.com.britenet.kta.entity.project.ProjectStatus;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.BeneficiaryRepository;
import pl.com.britenet.kta.repositories.ContractorsRepository;
import pl.com.britenet.kta.repositories.ProjectRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;
    private ContractorsRepository contractorsRepository;
    private BeneficiaryRepository beneficiaryRepository;

    public ProjectService(ProjectRepository projectRepository, ContractorsRepository contractorsRepository, BeneficiaryRepository beneficiaryRepository) {
        this.projectRepository = projectRepository;
        this.contractorsRepository = contractorsRepository;
        this.beneficiaryRepository = beneficiaryRepository;
    }

    @Transactional
    public void createProject(ProjectDto projectDto) {
        LocalDate startDate = LocalDate.parse(projectDto.getStartDate());
        LocalDate endDate = LocalDate.parse(projectDto.getEndDate());
        Set<Contractor> contractors = new HashSet<>();
        for (String id : projectDto.getContractorsIds()) {
            Contractor contractor = contractorsRepository.findOne(id);
            if (contractor == null)
                throw new BadRequestException("contractor not found");
            contractors.add(contractor);
        }
        Set<Beneficiary> beneficiaries =  new HashSet<>();
        for (String id : projectDto.getBeneficiariesIds()){
            Beneficiary beneficiary = beneficiaryRepository.findOne(id);
            if (beneficiary == null)
                throw new BadRequestException("beneficiary not found");
            beneficiaries.add(beneficiary);
        }
        Project project = new Project(projectDto.getName(), projectDto.getDescription(), startDate, endDate,
                ProjectStatus.valueOf(projectDto.getStatus()), contractors, beneficiaries);
        projectRepository.save(project);
    }

    @Transactional
    public List<Project> listAll() {
        return projectRepository.findAll();
    }

    public Project getProject(String id) {
        Project project = projectRepository.findOne(id);
        if (project == null)
            throw new BadRequestException("project not found");
        return project;
    }


}
