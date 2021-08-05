package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Team {
    private int id;
    private Leader leaderByLeaderId;
    private Collection<TeamMember> teamMembersById;

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
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @ManyToOne
    @JoinColumn(name = "leader_id", referencedColumnName = "id", nullable = false)
    public Leader getLeaderByLeaderId() {
        return leaderByLeaderId;
    }

    public void setLeaderByLeaderId(Leader leaderByLeaderId) {
        this.leaderByLeaderId = leaderByLeaderId;
    }

    @OneToMany(mappedBy = "teamByTeamId")
    public Collection<TeamMember> getTeamMembersById() {
        return teamMembersById;
    }

    public void setTeamMembersById(Collection<TeamMember> teamMembersById) {
        this.teamMembersById = teamMembersById;
    }
}
