package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Team;
import com.proline.OsErpProline.entity.TeamMember;

import java.io.Serializable;

public class TeamMemberDto implements Serializable {
    private Integer id;
    private EmployeeDto employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public TeamMember toTeamMember(){
        TeamMember teamMember = new TeamMember();

        teamMember.setId(this.id);

        if(teamMember != null)
            teamMember.setEmployeeByEmployeeId(this.employee.toEmployee());

        return teamMember;
    }
}
