package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "team_member", schema = "employee", catalog = "")
public class TeamMember {
    private int id;
    private Team teamByTeamId;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamMember that = (TeamMember) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = false)
    public Team getTeamByTeamId() {
        return teamByTeamId;
    }

    public void setTeamByTeamId(Team teamByTeamId) {
        this.teamByTeamId = teamByTeamId;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
