package pl.com.britenet.kta.entity.project;

import org.springframework.data.annotation.Id;

//KADRA z projektu
public class Contractor {

    @Id
    private String id;
    private ContractorType contractorType;
}
