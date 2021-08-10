package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Esat Sakarya
 * created at 8/9/2021
 */
@Entity
public class Team {
    private int id;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Leader leaderByLeaderId;
    private Collection<TeamMember> teamMembersById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "insert_time", nullable = true, insertable = false, updatable = false)
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @Column(name = "update_time", nullable = true, insertable = false, updatable = false)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                Objects.equals(insertTime, team.insertTime) &&
                Objects.equals(updateTime, team.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, insertTime, updateTime);
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
