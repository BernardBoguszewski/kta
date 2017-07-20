package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.BeneficiaryDto;
import pl.com.britenet.kta.entity.project.Beneficiary;
import pl.com.britenet.kta.services.BeneficiaryService;

import java.util.List;

@RestController
@RequestMapping("/beneficiaries")
public class BeneficiaryController {

    private BeneficiaryService beneficiaryService;

    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @PostMapping
    public void createBeneficiary(@RequestBody BeneficiaryDto beneficiaryDto){
        beneficiaryDto.validate();
        beneficiaryService.createBeneficiary(beneficiaryDto);
    }

    @GetMapping
    public List<Beneficiary> listAllBeneficiaries(){
        return beneficiaryService.listAll();
    }

    @GetMapping("/{id}")
    public Beneficiary getBeneficiary(@PathVariable String id){
        return beneficiaryService.getBeneficiary(id);
    }

    @PutMapping("/{id}")
    public void updateBeneficiary(@PathVariable String id, @RequestBody BeneficiaryDto beneficiaryDto){
        beneficiaryDto.validate();
        beneficiaryService.updateBeneficiary(id, beneficiaryDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBeneficiary(@PathVariable String id){
        beneficiaryService.deleteBeneficiary(id);
    }

}
