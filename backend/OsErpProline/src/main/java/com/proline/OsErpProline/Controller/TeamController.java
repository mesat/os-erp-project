package com.proline.OsErpProline.Controller;

import com.proline.OsErpProline.Repository.TeamRepository;
import com.proline.OsErpProline.dto.TeamDto;
import com.proline.OsErpProline.entity.Team;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @PostMapping("/team")
    Team newTeam(@RequestBody TeamDto newTeam) {
        /*if (newTeam.getTeamMembersById() != null)
            newTeam.getTeamMembersById().forEach(member -> member.setTeamByTeamId(newTeam));*/

        return teamRepository.save(newTeam.toTeam());
    }

    @GetMapping("/team")
    List<Team> getAllTeam(){
        return teamRepository.findAll();
    }

    @PutMapping("/team/{teamId}/{leaderEmployeeId}")
    @Transactional
    public void replaceTeam(@PathVariable Integer teamId,@PathVariable Integer leaderEmployeeId){
        Team team = teamRepository.findById(teamId).get();
        teamRepository.updateLeader(leaderEmployeeId,team.getLeaderByLeaderId().getId());
    }
}
