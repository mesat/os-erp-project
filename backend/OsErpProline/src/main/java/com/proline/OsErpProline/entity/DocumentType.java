package com.proline.OsErpProline.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "document_type", schema = "employee", catalog = "")
public class DocumentType {
    private String name;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Collection<Document> documentsByName;

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "insert_time")
    public Timestamp getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Timestamp insertTime) {
        this.insertTime = insertTime;
    }

    @Basic
    @Column(name = "update_time")
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
        DocumentType that = (DocumentType) o;
        return Objects.equals(name, that.name) && Objects.equals(insertTime, that.insertTime) && Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, insertTime, updateTime);
    }

    @OneToMany(mappedBy = "documentTypeByDocumentType")
    public Collection<Document> getDocumentsByName() {
        return documentsByName;
    }

    public void setDocumentsByName(Collection<Document> documentsByName) {
        this.documentsByName = documentsByName;
    }
}
