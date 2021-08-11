package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.TeamMemberRepository;
import com.proline.OsErpProline.entity.TeamMember;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamMemmberController {
    private final TeamMemberRepository teamMemberRepository;

    public TeamMemmberController(TeamMemberRepository teamMemberRepository) {
        this.teamMemberRepository = teamMemberRepository;
    }

    @PostMapping("/teammember")
    TeamMember newTeamMember(@RequestBody TeamMember teamMember){
        return teamMemberRepository.save(teamMember);
    }
}
