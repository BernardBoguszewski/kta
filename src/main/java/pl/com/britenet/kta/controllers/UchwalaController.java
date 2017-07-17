package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.domain.Uchwala;
import pl.com.britenet.kta.dtos.UchwalaDto;
import pl.com.britenet.kta.services.UchwalaService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-14.
 */
@RestController
@RequestMapping("/resolutions")
public class UchwalaController {

    private UchwalaService uchwalaService;

    public UchwalaController(UchwalaService uchwalaService) {
        this.uchwalaService = uchwalaService;
    }

    @PostMapping
    public void createResolution(@RequestBody UchwalaDto uchwalaDto){
        uchwalaService.createResolution(uchwalaDto);
    }

    @GetMapping
    public List<Uchwala> getAllResolutions(){
        return uchwalaService.getAllResolutions();
    }

    @GetMapping("/{id}")
    public Uchwala getResolutionById(@PathVariable String id){
        return uchwalaService.getUchwalaById(id);
    }

    @PutMapping("/{id}")
    public void updateResolution(@PathVariable String id, @RequestBody UchwalaDto uchwalaDto){
        uchwalaService.updateResolution(id, uchwalaDto);
    }

    @DeleteMapping("/{id}")
    public void deleteResolutionById(@PathVariable String id){
        uchwalaService.deleteResolution(id);
    }

}
