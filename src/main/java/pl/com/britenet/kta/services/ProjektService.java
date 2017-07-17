package pl.com.britenet.kta.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.dtos.ProjectDto;
import pl.com.britenet.kta.entity.project.Project;
import pl.com.britenet.kta.entity.project.ProjectStatus;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ProjektRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@Service
@AllArgsConstructor
public class ProjektService {

    private ProjektRepository projektRepository;

    @Transactional
    public void createProject(ProjectDto projectDto) {
        LocalDate startDate = LocalDate.parse(projectDto.getStartDate());
        LocalDate endDate = LocalDate.parse(projectDto.getEndDate());
        Project project = Project.builder().name(projectDto.getName()).description(projectDto.getDescription())
                .startDate(startDate).endDate(endDate).status(ProjectStatus.valueOf(projectDto.getStatus())).build();
        projektRepository.save(project);
    }

    @Transactional
    public List<Project> getAllProjects() {
        return projektRepository.findAll();
    }

    public void deleteProjectById(String id) {
        Project project = projektRepository.findOne(id);
        if(project == null)
            throw new BadRequestException("Projekt o podanym id nie istnieje");
        else
            projektRepository.delete(id);
    }

    @Transactional
    public Project getProject(String id) {
        Project project = projektRepository.findOne(id);
        if(project == null)
            throw new BadRequestException("Projekt o podanym id nie istnieje");
        else
            return project;
    }

    @Transactional
    public void updateProject(String id, ProjectDto projectDto) {
        Project project = projektRepository.findOne(id);
        if(project == null)
            throw new BadRequestException("Projekt o podanym id nie istnieje");
    }
}
