package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ContributionDto;
import pl.com.britenet.kta.entity.membership.Contribution;
import pl.com.britenet.kta.services.ContributionsService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/contributions")
public class ContributionsController {

    private ContributionsService contributionsService;

    public ContributionsController(ContributionsService contributionsService) {
        this.contributionsService = contributionsService;
    }

    @PostMapping
    public void createContribution(@RequestBody ContributionDto contributionDto){
        contributionDto.validate();
        contributionsService.createContribution(contributionDto);
    }

    @GetMapping
    public List<Contribution> getAllContributions(){
        return contributionsService.getAllContributions();
    }

    @GetMapping("/{id}")
    public Contribution getContribution(@PathVariable String id){
        return contributionsService.getContribution(id);
    }

    @PutMapping("/{id}")
    public void updateContribution(@PathVariable String id, @RequestBody ContributionDto contributionDto){
        contributionDto.validate();
        contributionsService.updateContribution(id, contributionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteContribution(@PathVariable String id){
        contributionsService.deleteContribution(id);
    }
}
