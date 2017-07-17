package pl.com.britenet.kta.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository;

/**
 * Created by Britenet on 2017-07-17.
 */
@Service
@AllArgsConstructor
public class MembersService {

    private MemberOfAssociationRepository memberOfAssociationRepository;


    public void createMember(MemberOfAssociationDto memberOfAssociationDto) {

    }

    public void listAll() {
        memberOfAssociationRepository.findAll();
    }
}
