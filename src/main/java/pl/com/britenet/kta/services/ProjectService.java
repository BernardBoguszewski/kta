package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import pl.com.britenet.kta.repositories.ProjectRepository;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


}
