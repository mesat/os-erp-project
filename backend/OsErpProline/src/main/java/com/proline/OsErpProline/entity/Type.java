package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

/**
 * @author Esat Sakarya
 * created at 8/9/2021
 */
@Entity
public class Type {
    private String name;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Collection<Document> documentsByName;

    @Id
    @Column(name = "name", nullable = false, length = 45)
    @SequenceGenerator(name = "name", sequenceName = "ORACLE_DB_SEQ_ID")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Type type = (Type) o;
        return Objects.equals(name, type.name) &&
                Objects.equals(insertTime, type.insertTime) &&
                Objects.equals(updateTime, type.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, insertTime, updateTime);
    }

    @OneToMany(mappedBy = "typeByType")
    public Collection<Document> getDocumentsByName() {
        return documentsByName;
    }

    public void setDocumentsByName(Collection<Document> documentsByName) {
        this.documentsByName = documentsByName;
    }
}
