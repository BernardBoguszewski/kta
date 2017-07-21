package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ProjectDto;
import pl.com.britenet.kta.entity.project.Project;
import pl.com.britenet.kta.services.ProjectService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public void createProject(@RequestBody ProjectDto projectDto) {
        projectService.createProject(projectDto);
    }

    @GetMapping
    public List<Project> listAllProjects(){
        return projectService.listAll();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable String id){
        return projectService.getProject(id);
    }


}
