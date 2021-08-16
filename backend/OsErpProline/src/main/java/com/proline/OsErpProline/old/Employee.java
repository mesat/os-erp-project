/*package com.proline.OsErpProline.old;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private String sur_name;
    private String rol;
    private String bio;

    public Employee () {}
    public Employee(String name, String sur_name, String rol, String bio) {
        this.name = name;
        this.sur_name = sur_name;
        this.rol = rol;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return sur_name;
    }

    public void setSurName(String surName) {
        this.sur_name = sur_name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && Objects.equals(name, employee.name) && Objects.equals(sur_name, employee.sur_name) && Objects.equals(rol, employee.rol) && Objects.equals(bio, employee.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sur_name, rol, bio);
    }   
}

*/