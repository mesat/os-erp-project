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
public class Leader {
    private Integer id;
    private String rol;
    private Timestamp insertTime;
    private Timestamp updateTime;

    private Employee employeeByEmployeeId;
    private Collection<Team> teamsById;

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
    @Column(name = "rol", nullable = true, length = 45)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
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
        Leader leader = (Leader) o;
        return id == leader.id &&
                Objects.equals(rol, leader.rol) &&
                Objects.equals(insertTime, leader.insertTime) &&
                Objects.equals(updateTime, leader.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol, insertTime, updateTime);
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @OneToMany(mappedBy = "leaderByLeaderId",cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
    @JsonBackReference(value = "teamMembersById")
    public Collection<Team> getTeamsById() {
        return teamsById;
    }

    public void setTeamsById(Collection<Team> teamsById) {
        this.teamsById = teamsById;
    }
}
