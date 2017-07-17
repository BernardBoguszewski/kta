package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ProjectDto;
import pl.com.britenet.kta.entity.project.Project;
import pl.com.britenet.kta.services.ProjektService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    private ProjektService projektService;

    public ProjectController(ProjektService projektService) {
        this.projektService = projektService;
    }

    @PostMapping
    public void createProject(@RequestBody ProjectDto projectDto){
        projektService.createProject(projectDto);
    }

    @GetMapping
    public List<Project> listAllProjects(){
        return projektService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable String id){
        return projektService.getProject(id);
    }


    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable String id){
        projektService.deleteProjectById(id);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable String id, @RequestBody ProjectDto projectDto){
        projektService.updateProject(id, projectDto);
    }

}
