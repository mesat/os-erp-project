package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Contact {
    private int id;
    private String link;
    private Socialmedia socialmediaBySocialmediaId;
    private Employee employeeByEmployeeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "link")
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id &&  Objects.equals(link, contact.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link);
    }

    @ManyToOne
    @JoinColumn(name = "socialmedia_id", referencedColumnName = "id", nullable = false)
    public Socialmedia getSocialmediaBySocialmediaId() {
        return socialmediaBySocialmediaId;
    }

    public void setSocialmediaBySocialmediaId(Socialmedia socialmediaBySocialmediaId) {
        this.socialmediaBySocialmediaId = socialmediaBySocialmediaId;
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
