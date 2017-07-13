package pl.com.britenet.kta.factories;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.domain.Projekt;
import pl.com.britenet.kta.dtos.ProjektDto;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-13.
 */
@Component
public class ProjectFactory {
    public Projekt create(ProjektDto projektDto) {
        LocalDate startDate = LocalDate.parse(projektDto.getDataUtworzenia());
        LocalDate endDate = LocalDate.parse(projektDto.getDataZamkniecia());
        return new Projekt(projektDto.getNazwa(), projektDto.getOpis(), startDate, endDate);
    }
}
