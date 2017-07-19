package pl.com.britenet.kta.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.builders.MemberBuilder;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.entity.membership.MemberOfAssociationStatus;
import pl.com.britenet.kta.entity.resolution.Resolution;
import pl.com.britenet.kta.exceptions.BadRequestException;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;
import pl.com.britenet.kta.repositories.ResolutionRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@Service
public class MembersService {

    private MemberOfAssociationRepository memberOfAssociationRepository;
    private MemberBuilder memberBuilder;
    private ResolutionRepository resolutionRepository;

    public MembersService(MemberOfAssociationRepository memberOfAssociationRepository, MemberBuilder memberBuilder, ResolutionRepository resolutionRepository) {
        this.memberOfAssociationRepository = memberOfAssociationRepository;
        this.memberBuilder = memberBuilder;
        this.resolutionRepository = resolutionRepository;
    }

    @Transactional
    public void createMember(MemberOfAssociationDto memberOfAssociationDto) {
        MemberOfAssociation memberOfAssociation = memberBuilder.create(memberOfAssociationDto);
        memberOfAssociationRepository.save(memberOfAssociation);
    }

    @Transactional
    public List<MemberOfAssociation> listAll() {
        return memberOfAssociationRepository.findAll();
    }

    @Transactional
    public MemberOfAssociation getMember(String id) {
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(id);
        if (memberOfAssociation == null)
            throw new BadRequestException("member does not exist");
        else
            return memberOfAssociation;
    }

    @Transactional
    public void updateMember(String id, MemberOfAssociationDto dto) {
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(id);
        if (memberOfAssociation == null)
            throw new BadRequestException("member does not exist");
        LocalDate startDate = LocalDate.parse(dto.getStartDate());
        LocalDate endDate = LocalDate.parse(dto.getEndDate());
        MemberOfAssociationStatus status = MemberOfAssociationStatus.valueOf(dto.getStatus());
        Resolution resolution = resolutionRepository.findOne(dto.getResolutionId());
        if(resolution == null)
            throw new BadRequestException("resolution does not found");
        memberOfAssociation.setName(dto.getName());
        memberOfAssociation.setNip(dto.getNip());
        memberOfAssociation.setRegon(dto.getRegon());
        memberOfAssociation.setEmail(dto.getEmail());
        memberOfAssociation.setPhoneNumber(dto.getPhoneNumber());
        memberOfAssociation.setStartDate(startDate);
        memberOfAssociation.setEndDate(endDate);
        memberOfAssociation.setStatus(status);
        memberOfAssociation.setMemberOfAssociationType(dto.getMemberOfAssociationType());
        memberOfAssociationRepository.save(memberOfAssociation);
    }

    @Transactional
    public void deleteMember(String id) {
        MemberOfAssociation memberOfAssociation = memberOfAssociationRepository.findOne(id);
        if (memberOfAssociation == null)
            throw new BadRequestException("member does not exist");
        else
            memberOfAssociationRepository.delete(id);
    }
}
