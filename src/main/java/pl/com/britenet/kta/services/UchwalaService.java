package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.domain.Uchwala;
import pl.com.britenet.kta.dtos.UchwalaDto;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.UchwalaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Britenet on 2017-07-14.
 */
@Service
public class UchwalaService {

    private UchwalaRepository uchwalaRepository;

    public UchwalaService(UchwalaRepository uchwalaRepository) {
        this.uchwalaRepository = uchwalaRepository;
    }

    @Transactional
    public void createResolution(UchwalaDto uchwalaDto) {
        LocalDate date = LocalDate.parse(uchwalaDto.getDataUchwalenia());
        Uchwala uchwala = Uchwala.builder().tytul(uchwalaDto.getTytul()).opis(uchwalaDto.getOpis()).numer(uchwalaDto.getNumer()).dataUchwalenia(date).build();
        uchwalaRepository.save(uchwala);
    }

    @Transactional
    public List<Uchwala> getAllResolutions() {
        return uchwalaRepository.findAll();

    }

    @Transactional
    public Uchwala getUchwalaById(String id) {
        Uchwala uchwala = uchwalaRepository.findOne(id);
        if(uchwala == null)
            throw new BadRequestException("Uchwala o podanym id nie istnieje");
        else
            return uchwala;
    }

    @Transactional
    public void updateResolution(String id, UchwalaDto uchwalaDto) {
        Uchwala uchwala = uchwalaRepository.findOne(id);
        if(uchwala == null)
            throw new BadRequestException("Uchwala o podanym id nie istnieje");
        else{
            LocalDate date = LocalDate.parse(uchwalaDto.getDataUchwalenia());
            uchwala.setNumer(uchwalaDto.getNumer());
            uchwala.setOpis(uchwalaDto.getOpis());
            uchwala.setTytul(uchwalaDto.getTytul());
            uchwala.setDataUchwalenia(date);
            uchwalaRepository.save(uchwala);
        }
    }

    @Transactional
    public void deleteResolution(String id) {
        Uchwala uchwala = uchwalaRepository.findOne(id);
        if(uchwala == null)
            throw new BadRequestException("Uchwala o podanym id nie istnieje");
        else
            uchwalaRepository.delete(id);
    }
}
