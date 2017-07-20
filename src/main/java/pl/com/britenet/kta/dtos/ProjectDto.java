package pl.com.britenet.kta.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Britenet on 2017-07-13.
 */

public class ProjectDto {

    private String name;
    private String description;

    private String startDate;
    private String endDate;

    private String status;
//    private Note note; todo

    private Set<String> contractorsIds;

    private Set<String> beneficiariesIds;

    private Set<String> taskIds;

    public ProjectDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<String> getContractorsIds() {
        return contractorsIds;
    }

    public void setContractorsIds(Set<String> contractorsIds) {
        this.contractorsIds = contractorsIds;
    }

    public Set<String> getBeneficiariesIds() {
        return beneficiariesIds;
    }

    public void setBeneficiariesIds(Set<String> beneficiariesIds) {
        this.beneficiariesIds = beneficiariesIds;
    }

    public Set<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(Set<String> taskIds) {
        this.taskIds = taskIds;
    }

    //    public void validate(){
//        if (nazwa == null || nazwa.trim().isEmpty())
//            throw new BadRequestException("Nazwa nie moze byc pusta");
//        if (opis == null || opis.trim().isEmpty())
//            throw new BadRequestException("Opis nie moze byc pusty");
//        if(!dataUtworzenia.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
//            throw new BadRequestException("Niepoprawna data utworzenia");
//        if(!dataZamkniecia.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$"))
//            throw new BadRequestException("Niepoprawna data zamkniecia");
//    }
}
