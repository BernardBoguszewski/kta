package pl.com.britenet.kta.factories;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.domain.Projekt;
import pl.com.britenet.kta.dtos.ProjectDto;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-13.
 */
@Component
public class ProjectFactory {
    public Projekt create(ProjectDto projectDto) {
        LocalDate startDate = LocalDate.parse(projectDto.getDataUtworzenia());
        LocalDate endDate = LocalDate.parse(projectDto.getDataZamkniecia());
        return new Projekt(projectDto.getNazwa(), projectDto.getOpis(), startDate, endDate);
    }
}
