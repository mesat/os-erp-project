package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Socialmedia {
    private int id;
    private String platform;
    private Collection<Contact> contactsById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "platform")
    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socialmedia that = (Socialmedia) o;
        return id == that.id && Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, platform);
    }

    @OneToMany(mappedBy = "socialmediaBySocialmediaId")
    public Collection<Contact> getContactsById() {
        return contactsById;
    }

    public void setContactsById(Collection<Contact> contactsById) {
        this.contactsById = contactsById;
    }
}
