package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.Repository.TeamRepository;
import com.proline.OsErpProline.entity.Team;

import java.io.Serializable;

public class TeamToLeaderDto implements Serializable {
    private Integer teamId;

    private Integer employeeLeaderId;

    private final TeamRepository teamRepository;

    public TeamToLeaderDto(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getEmployeeLeaderId() {
        return employeeLeaderId;
    }

    public void setEmployeeLeaderId(Integer employeeLeaderId) {
        this.employeeLeaderId = employeeLeaderId;
    }

}
