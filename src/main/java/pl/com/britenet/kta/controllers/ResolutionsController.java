package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ResolutionDto;
import pl.com.britenet.kta.entity.resolution.Resolution;
import pl.com.britenet.kta.services.ResolutionsService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-14.
 */
@RestController
@RequestMapping("/resolutions")
public class ResolutionsController {

    private ResolutionsService resolutionsService;

    public ResolutionsController(ResolutionsService resolutionsService) {
        this.resolutionsService = resolutionsService;
    }

    @PostMapping
    public void createResolution(@RequestBody ResolutionDto resolutionDto){
        resolutionsService.createResolution(resolutionDto);
    }

    @GetMapping
    public List<Resolution> getAllResolutions(){
        return resolutionsService.getAllResolutions();
    }

    @GetMapping("/{id}")
    public Resolution getResolutionById(@PathVariable String id){
        return resolutionsService.getResolutionById(id);
    }

    @PutMapping("/{id}")
    public void updateResolution(@PathVariable String id, @RequestBody ResolutionDto resolutionDto){
        resolutionsService.updateResolution(id, resolutionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteResolutionById(@PathVariable String id){
        resolutionsService.deleteResolution(id);
    }

}
