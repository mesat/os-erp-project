package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.TeamRepository;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Socialmedia;
import com.proline.OsErpProline.entity.Team;
import com.proline.OsErpProline.entity.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/team")
    Team newEmployee(@RequestBody Team newTeam, TeamMember teamMember) {
        if (newTeam.getTeamMembersById() != null)
            newTeam.getTeamMembersById().forEach(member -> member.setTeamByTeamId(newTeam));
        return teamRepository.save(newTeam);
    }

    @GetMapping("/team")
    List<Team> getAllTeam(){
        return teamRepository.findAll();
    }
}
