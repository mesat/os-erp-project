package com.proline.OsErpProline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Esat Sakarya
 * created at 8/9/2021
 */
@Entity
public class Contact {
    private Integer id;
    private String link;
    private String nick;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Employee employeeByEmployeeId;
    private Socialmedia socialmediaBySocialmediaPlatform;

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
    @Column(name = "link", nullable = true, length = 45)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "nick", nullable = true, length = 45)
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
        Contact contact = (Contact) o;
        return id == contact.id &&
                Objects.equals(link, contact.link) &&
                Objects.equals(insertTime, contact.insertTime) &&
                Objects.equals(updateTime, contact.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link, insertTime, updateTime);
    }

    @ManyToOne(targetEntity = Employee.class,optional = false,cascade = {CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonBackReference("contactsById")
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "socialmedia_platform", referencedColumnName = "platform", nullable = false)
    public Socialmedia getSocialmediaBySocialmediaPlatform() {
        return socialmediaBySocialmediaPlatform;
    }

    public void setSocialmediaBySocialmediaPlatform(Socialmedia socialmediaBySocialmediaPlatform) {
        this.socialmediaBySocialmediaPlatform = socialmediaBySocialmediaPlatform;
    }
}
