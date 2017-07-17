package pl.com.britenet.kta.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.com.britenet.kta.dtos.MemberOfAssociationDto;
import pl.com.britenet.kta.services.MembersService;

/**
 * Created by Britenet on 2017-07-17.
 */
@RestController
@RequestMapping("/members")
@AllArgsConstructor
public class MembersController {

    private MembersService membersService;

    @PostMapping
    public void createMember(@RequestBody MemberOfAssociationDto memberOfAssociationDto){
        membersService.createMember(memberOfAssociationDto);
    }

    @GetMapping
    public void listAllMembers(){
        membersService.listAll();
    }

}
