package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    private int id;
    private String name;
    private String surname;
    private String rol;
    private String bio;
    private Collection<Contact> contactsById;
    private Collection<Leader> leadersById;
    private Collection<TeamMember> teamMembersById;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    @Basic
    @Column(name = "rol")
    public String getRol()
    {
        return rol;
    }

    public void setRol(String rol)
    {
        this.rol = rol;
    }

    @Basic
    @Column(name = "bio")
    public String getBio()
    {
        return bio;
    }

    public void setBio(String bio)
    {
        this.bio = bio;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(rol, employee.rol) && Objects.equals(bio, employee.bio);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, surname, rol, bio);
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<Contact> getContactsById()
    {
        return contactsById;
    }

    public void setContactsById(Collection<Contact> contactsById)
    {
        this.contactsById = contactsById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<Leader> getLeadersById()
    {
        return leadersById;
    }

    public void setLeadersById(Collection<Leader> leadersById)
    {
        this.leadersById = leadersById;
    }

    @OneToMany(mappedBy = "employeeByEmployeeId")
    public Collection<TeamMember> getTeamMembersById()
    {
        return teamMembersById;
    }

    public void setTeamMembersById(Collection<TeamMember> teamMembersById)
    {
        this.teamMembersById = teamMembersById;
    }
}
