package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Leader;
import com.proline.OsErpProline.entity.Team;
import com.proline.OsErpProline.entity.TeamMember;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class TeamDto implements Serializable {

    private Integer id;

    private String teamName;

    private Integer leaderEmployeeId;
    private String role;

    private List<Integer> employeeIdList;

    public Integer getLeaderEmployeeId() {
        return leaderEmployeeId;
    }

    public void setLeaderEmployeeId(Integer leaderEmployeeId) {
        this.leaderEmployeeId = leaderEmployeeId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Integer> getEmployeeIdList() {
        return employeeIdList;
    }

    public void setEmployeeIdList(List<Integer> employeeIdList) {
        this.employeeIdList = employeeIdList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getEmployee() {
        return leaderEmployeeId;
    }

    public void setEmployee(Integer employee) {
        this.leaderEmployeeId = employee;
    }

    public Team toTeam(){
        Team team = new Team();

        team.setName(this.teamName);
        Leader leader = new Leader();
        Employee employee = new Employee();
        employee.setId(this.getEmployee());
        leader.setEmployeeByEmployeeId(employee);
        leader.setRol(this.role);
        team.setLeaderByLeaderId(leader);

        List<TeamMember> teamMemberList =
        employeeIdList.stream().map(calisanId -> {
            Employee employee1 = new Employee();
            employee1.setId(calisanId);
            TeamMember teamMember = new TeamMember();
            teamMember.setEmployeeByEmployeeId(employee1);
            teamMember.setTeamByTeamId(team);
            return teamMember;
        }).collect(Collectors.toList());
        team.setTeamMembersById(teamMemberList);



        return team;
    }
}
