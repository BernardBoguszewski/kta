package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.ContractorDto;
import pl.com.britenet.kta.entity.project.Contractor;
import pl.com.britenet.kta.services.ContractorsService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/contractors")
public class ContractorsController {

    private ContractorsService contractorsService;

    public ContractorsController(ContractorsService contractorsService) {
        this.contractorsService = contractorsService;
    }

    @PostMapping
    public void createContractor(@RequestBody ContractorDto contractorDto){
        contractorDto.validate();
        contractorsService.createContractor(contractorDto);
    }

    @GetMapping
    public List<Contractor> listAllContractors(){
        return contractorsService.listAll();
    }

    @GetMapping("/{id}")
    public Contractor getContractor(@PathVariable String id){
        return contractorsService.getContractor(id);
    }

    @PutMapping("/{id}")
    public void updateContractor(@PathVariable String id, @RequestBody ContractorDto contractorDto){
        contractorDto.validate();
        contractorsService.updateContractor(id, contractorDto);
    }

    @DeleteMapping("/{id}")
    public void deleteContractor(@PathVariable String id){
        contractorsService.deleteContractor(id);
    }

}
