package pl.com.britenet.kta.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.builders.ContributionBuilder;
import pl.com.britenet.kta.dtos.ContributionDto;
import pl.com.britenet.kta.entity.membership.Contribution;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.ContributionsRepository;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContributionsService {

    private ContributionsRepository contributionsRepository;
    private ContributionBuilder contributionBuilder;
    private MemberOfAssociationRepository memberOfAssociationRepository;

    public ContributionsService(ContributionsRepository contributionsRepository, ContributionBuilder contributionBuilder, MemberOfAssociationRepository memberOfAssociationRepository) {
        this.contributionsRepository = contributionsRepository;
        this.contributionBuilder = contributionBuilder;
        this.memberOfAssociationRepository = memberOfAssociationRepository;
    }

    @Transactional
    public void createContribution(ContributionDto contributionDto) {
        Contribution contribution = contributionBuilder.create(contributionDto);
        contributionsRepository.save(contribution);
    }

    @Transactional
    public List<Contribution> getAllContributions() {
        return contributionsRepository.findAll();
    }

    @Transactional
    public Contribution getContribution(String id) {
        Contribution contribution = contributionsRepository.findOne(id);
        if (contribution == null)
            throw new BadRequestException("contribution not found");
        else
            return contribution;
    }

    @Transactional
    public void updateContribution(String id, ContributionDto contributionDto) {
        Contribution contribution = contributionsRepository.findOne(id);
        if (contribution == null)
            throw new BadRequestException("contribution not found");
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(contributionDto.getMemberOfAssociationId());
        if (memberOfAssociation == null)
            throw new BadRequestException("incorrect member id");
        LocalDate dateOfPayment = LocalDate.parse(contributionDto.getDateOfPayment());
        contribution.setMemberOfAssociation(memberOfAssociation);
        contribution.setDateOfPayment(dateOfPayment);
        contribution.setDescription(contributionDto.getDescription());
        contributionsRepository.save(contribution);
    }

    @Transactional
    public void deleteContribution(String id) {
        Contribution contribution = contributionsRepository.findOne(id);
        if (contribution == null)
            throw new BadRequestException("contribution not found");
        contributionsRepository.delete(id);
    }
}
