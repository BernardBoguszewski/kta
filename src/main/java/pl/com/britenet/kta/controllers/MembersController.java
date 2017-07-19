package pl.com.britenet.kta.controllers;

import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.entity.membership.MemberOfAssociation;
import pl.com.britenet.kta.services.MembersService;

import java.util.List;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/members")
public class MembersController {

    private MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @PostMapping
    public void createMember(@RequestBody MemberOfAssociationDto memberOfAssociationDto){
        membersService.createMember(memberOfAssociationDto);
    }

    @GetMapping
    public List<MemberOfAssociation> listAllMembers(){
        return membersService.listAll();
    }

    @GetMapping("/{id}")
    public MemberOfAssociation getMember(@PathVariable String id){
        return membersService.getMember(id);
    }

    @PutMapping("/{id}")
    public void updateMember(@PathVariable String id, @RequestBody MemberOfAssociationDto dto){
        membersService.updateMember(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable String id){
        membersService.deleteMember(id);
    }

}
