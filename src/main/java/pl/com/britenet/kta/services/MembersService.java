package pl.com.britenet.kta.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.britenet.kta.builders.MemberBuilder;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@Service
public class MembersService {

    private MemberOfAssociationRepository memberOfAssociationRepository;
    private MemberBuilder memberBuilder;

    public MembersService(MemberOfAssociationRepository memberOfAssociationRepository, MemberBuilder memberBuilder) {
        this.memberOfAssociationRepository = memberOfAssociationRepository;
        this.memberBuilder = memberBuilder;
    }

    @Transactional
    public void createMember(MemberOfAssociationDto memberOfAssociationDto) {
        MemberOfAssociation memberOfAssociation = memberBuilder.create(memberOfAssociationDto);
        memberOfAssociationRepository.save(memberOfAssociation);
    }


    public List<MemberOfAssociation> listAll() {
        return memberOfAssociationRepository.findAll();
    }
}
