package pl.com.britenet.kta.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Created by Britenet on 2017-07-13.
 */
@Data
@NoArgsConstructor
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
