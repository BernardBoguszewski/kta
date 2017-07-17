package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.domain.Projekt;
import pl.com.britenet.kta.dtos.ProjektDto;
import pl.com.britenet.kta.services.ProjektService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-13.
 */
@RestController
@RequestMapping("/projects")
public class ProjektController {

    private ProjektService projektService;

    public ProjektController(ProjektService projektService) {
        this.projektService = projektService;
    }

    @PostMapping
    public void createProject(@RequestBody ProjektDto projektDto){
        projektDto.validate();
        projektService.createProject(projektDto);
    }

    @GetMapping
    public List<Projekt> getProjekt(){
        return projektService.getAllProjects();
    }

    @GetMapping("/{id}")
    public Projekt getProjektById(@PathVariable String id){
        return projektService.getProjekt(id);
    }


    @DeleteMapping("/{id}")
    public void deleteProjectById(@PathVariable String id){
        projektService.deleteProjectById(id);
    }

    @PutMapping("/{id}")
    public void updateProject(@PathVariable String id, @RequestBody ProjektDto projektDto){
        projektService.updateProject(id, projektDto);
    }

}
