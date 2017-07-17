package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.dtos.ResolutionDto;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.entity.resolution.Resolution;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;
import pl.com.britenet.kta.repositories.ResolutionRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Britenet on 2017-07-14.
 */
@Service
public class ResolutionsService {

    private ResolutionRepository resolutionRepository;
    private MemberOfAssociationRepository memberOfAssociationRepository;

    public ResolutionsService(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    @Transactional
    public void createResolution(ResolutionDto resolutionDto) {
        LocalDate date = LocalDate.parse(resolutionDto.getDate());
        Resolution previousResolution = resolutionRepository.findOne(resolutionDto.getPreviousResolutionId());
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(resolutionDto.getMemberOfAssociationId());
        Resolution resolution = Resolution.builder().title(resolutionDto.getTitle()).description(resolutionDto.getDescription())
                .numeration(resolutionDto.getNumeration()).date(date).previousResultion(previousResolution).memberOfAssociation(memberOfAssociation).build();
        resolutionRepository.save(resolution);
    }

    @Transactional
    public List<Resolution> getAllResolutions() {
        return resolutionRepository.findAll();
    }

    @Transactional
    public Resolution getResolutionById(String id) {
        Resolution resolution = resolutionRepository.findOne(id);
        if (resolution == null)
            throw new BadRequestException("Uchwala o podanym id nie istnieje");
        else
            return resolution;
    }

    @Transactional
    public void updateResolution(String id, ResolutionDto resolutionDto) {
        Resolution resolution = resolutionRepository.findOne(id);
        if(resolution == null){
            throw new BadRequestException("resolution not found");
        } else {
            LocalDate date = LocalDate.parse(resolutionDto.getDate());
            Resolution previousResolution = resolutionRepository.findOne(resolutionDto.getPreviousResolutionId());
            MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(resolutionDto.getMemberOfAssociationId());
            resolution.setTitle(resolutionDto.getTitle());
            resolution.setDescription(resolutionDto.getDescription());
            resolution.setNumeration(resolutionDto.getNumeration());
            resolution.setDate(date);
            resolution.setPreviousResultion(previousResolution);
            resolution.setMemberOfAssociation(memberOfAssociation);
            resolutionRepository.save(resolution);
        }

//        Optional.ofNullable(resolutionRepository.findOne(id))
//                .map(resolution -> update(resolutionDto, resolution))
//                .map(resolution -> resolutionRepository.save(resolution))
//                .orElseThrow(() -> new BadRequestException("Uchwala o podanym id nie istnieje"));
    }


    @Transactional
    public void deleteResolution(String id) {
//        Uchwala uchwala = uchwalaRepository.findOne(id);
//        if(uchwala == null)
//            throw new BadRequestException("Uchwala o podanym id nie istnieje");
//        else
//            uchwalaRepository.delete(id);

        Resolution resolution = Optional.ofNullable(resolutionRepository.findOne(id))
                .orElseThrow(() -> new BadRequestException("Uchwala o podanym id nie istnieje"));
        resolutionRepository.delete(resolution);
    }
}
