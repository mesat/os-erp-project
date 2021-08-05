package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Leader {
    private int id;
    private String rol;
    private Employee employeeByEmployeeId;
    private Collection<Team> teamsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rol")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leader leader = (Leader) o;
        return id == leader.id && Objects.equals(rol, leader.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol);
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @OneToMany(mappedBy = "leaderByLeaderId")
    public Collection<Team> getTeamsById() {
        return teamsById;
    }

    public void setTeamsById(Collection<Team> teamsById) {
        this.teamsById = teamsById;
    }
}
