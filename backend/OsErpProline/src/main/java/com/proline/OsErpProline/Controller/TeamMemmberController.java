package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Exception.EmployeeNotFoundException;
import com.proline.OsErpProline.Exception.TeamMemberException;
import com.proline.OsErpProline.Repository.TeamMemberRepository;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.TeamMember;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/teammember/{id}")
    TeamMember one(@PathVariable Integer id) {

        return teamMemberRepository.findById(id)
                .orElseThrow(()->new TeamMemberException(id));
    }

    @GetMapping("/teammember")
    List<TeamMember> all() {
        return teamMemberRepository.findAll();
    }
}
