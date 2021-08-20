package com.proline.OsErpProline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

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
    private Integer id;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private String teamName;
    private Leader leaderByLeaderId;
    private Collection<TeamMember> teamMembersById;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    public Integer getId() {
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

    @Basic
    @Column(name = "team_name", nullable = true, length = 45)
    public String getName() {
        return teamName;
    }

    public void setName(String name) {
        this.teamName = name;
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

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "leader_id", referencedColumnName = "id", nullable = false)
    public Leader getLeaderByLeaderId() {
        return leaderByLeaderId;
    }

    public void setLeaderByLeaderId(Leader leaderByLeaderId) {
        this.leaderByLeaderId = leaderByLeaderId;
    }

    @OneToMany(mappedBy = "teamByTeamId",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    public Collection<TeamMember> getTeamMembersById() {
        return teamMembersById;
    }

    public void setTeamMembersById(Collection<TeamMember> teamMembersById) {
        this.teamMembersById = teamMembersById;
    }
}
