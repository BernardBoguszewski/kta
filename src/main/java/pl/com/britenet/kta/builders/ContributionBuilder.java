package pl.com.britenet.kta.builders;

import org.springframework.stereotype.Component;
import pl.com.britenet.kta.dtos.ContributionDto;
import pl.com.britenet.kta.entity.membership.Contribution;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;

import java.time.LocalDate;

@Component
public class ContributionBuilder {

    private MemberOfAssociationRepository memberOfAssociationRepository;

    public ContributionBuilder(MemberOfAssociationRepository memberOfAssociationRepository) {
        this.memberOfAssociationRepository = memberOfAssociationRepository;
    }

    public Contribution create(ContributionDto contributionDto){
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(contributionDto.getMemberOfAssociationId());
        if (memberOfAssociation == null)
            throw new BadRequestException("incorrect member id");
        LocalDate dateOfPayment = LocalDate.parse(contributionDto.getDateOfPayment());
        return new Contribution(memberOfAssociation, dateOfPayment, contributionDto.getDescription());
    }
}
