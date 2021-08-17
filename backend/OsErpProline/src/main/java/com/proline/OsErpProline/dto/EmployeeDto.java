package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Leader;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public class EmployeeDto implements Serializable {
    private Integer id;
    private String name;
    private String surname;
    private String rol;
    private String bio;
    private Date startDate;
    private Collection<ContactDto> contactsById;
    private Collection<DocumentDto> documentsById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Collection<ContactDto> getContactsById() {
        return contactsById;
    }

    public void setContactsById(Collection<ContactDto> contactsById) {
        this.contactsById = contactsById;
    }

    public Collection<DocumentDto> getDocumentsById() {
        return documentsById;
    }

    public void setDocumentsById(Collection<DocumentDto> documentsById) {
        this.documentsById = documentsById;
    }

    public Employee toEmployee() {
        Employee employee = new Employee();
        employee.setBio(this.bio);
        employee.setContactsById(this.contactsById.stream().map(ContactDto::toContact).collect(Collectors.toList()));
        employee.setDocumentsById(this.documentsById.stream().map(DocumentDto::toDocument).collect(Collectors.toList()));
        employee.setName(this.name);
        employee.setRol(this.rol);
        employee.setSurname(this.surname);
        return employee;
    }
}
