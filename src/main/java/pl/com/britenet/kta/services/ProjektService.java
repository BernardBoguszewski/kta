package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.domain.Projekt;
import pl.com.britenet.kta.dtos.ProjektDto;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.factories.ProjectFactory;
import pl.com.britenet.kta.repositories.ProjektRepository;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@Service
public class ProjektService {

    private ProjektRepository projektRepository;
    private ProjectFactory projectFactory;


    public ProjektService(ProjektRepository projektRepository, ProjectFactory projectFactory) {
        this.projektRepository = projektRepository;
        this.projectFactory = projectFactory;
    }

    @Transactional
    public void createProject(ProjektDto projektDto) {
        Projekt projekt = projectFactory.create(projektDto);
        projektRepository.save(projekt);
    }

    @Transactional
    public List<Projekt> getAllProjects() {
        return projektRepository.findAll();
    }

    public void deleteProjectById(String id) {
        Projekt projekt = projektRepository.findOne(id);
        if(projekt == null)
            throw new BadRequestException("Projekt o podanym id nie istnieje");
        else
            projektRepository.delete(id);
    }
}
