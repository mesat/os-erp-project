package com.proline.OsErpProline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Esat Sakarya
 * created at 8/9/2021
 */
@Entity
public class Employee {
    private Integer id;
    private String name;
    private String surname;
    private String rol;
    private String bio;
    private Date startDate;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Collection<Contact> contactsById;
    private Collection<Document> documentsById;
    private Collection<Leader> leadersById;
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

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = true, length = 45)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
    @Column(name = "bio", nullable = true, length = 45)
    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(rol, employee.rol) &&
                Objects.equals(bio, employee.bio) &&
                Objects.equals(insertTime, employee.insertTime) &&
                Objects.equals(updateTime, employee.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, rol, bio, insertTime, updateTime);
    }

    @OneToMany(mappedBy = "employeeByEmployeeId",cascade = {CascadeType.MERGE,CascadeType.PERSIST},orphanRemoval = true)
    @JsonBackReference
    public Collection<Contact> getContactsById() {
        return contactsById;
    }

    public void setContactsById(Collection<Contact> contactsById) {
        this.contactsById = contactsById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId",orphanRemoval = true)
    @JsonBackReference
    public Collection<Document> getDocumentsById() {
        return documentsById;
    }

    public void setDocumentsById(Collection<Document> documentsById) {
        this.documentsById = documentsById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId",orphanRemoval = true)
    @JsonBackReference
    public Collection<Leader> getLeadersById() {
        return leadersById;
    }

    public void setLeadersById(Collection<Leader> leadersById) {
        this.leadersById = leadersById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId",orphanRemoval = true)
    @JsonBackReference
    public Collection<TeamMember> getTeamMembersById() {
        return teamMembersById;
    }

    public void setTeamMembersById(Collection<TeamMember> teamMembersById) {
        this.teamMembersById = teamMembersById;
    }
}
