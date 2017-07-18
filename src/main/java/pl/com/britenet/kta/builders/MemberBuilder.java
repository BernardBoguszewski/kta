package pl.com.britenet.kta.builders;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.entity.membership.MemberOfAssociationStatus;
import pl.com.britenet.kta.entity.resolution.Resolution;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ResolutionRepository;

import java.time.LocalDate;

/**
 * Created by Britenet on 2017-07-18.
 */
@Component
public class MemberBuilder {

    private ResolutionRepository resolutionRepository;

    public MemberBuilder(ResolutionRepository resolutionRepository) {
        this.resolutionRepository = resolutionRepository;
    }

    public MemberOfAssociation create(MemberOfAssociationDto dto){
        LocalDate startDate = LocalDate.parse(dto.getStartDate());
        LocalDate endDate = LocalDate.parse(dto.getEndDate());
        MemberOfAssociationStatus status = MemberOfAssociationStatus.valueOf(dto.getStatus());
        Resolution resolution = resolutionRepository.findOne(dto.getResolutionId());
        if(resolution == null)
            throw new BadRequestException("resolution does not found");
        return new MemberOfAssociation(dto.getName(), dto.getNip(), dto.getRegon(), dto.getAddress(), dto.getEmail(),
                dto.getPhoneNumber(), startDate, endDate, status, dto.getMemberOfAssociationType(), resolution);
    }
}
