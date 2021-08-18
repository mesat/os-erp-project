package com.proline.OsErpProline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Esat Sakarya
 * created at 8/9/2021
 */
@Entity
public class Document {
    private Integer id;
    private byte[] documentData;
    private Timestamp insertTime;
    private Timestamp updateTime;
    private Employee employeeByEmployeeId;
    private Type typeByType;
    private DocumentType documentTypeByDocumentType;

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "document_data", nullable = true)
    public byte[] getDocumentData() {
        return documentData;
    }

    public void setDocumentData(byte[] documentData) {
        this.documentData = documentData;
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
        Document document = (Document) o;
        return id == document.id &&
                Arrays.equals(documentData, document.documentData) &&
                Objects.equals(insertTime, document.insertTime) &&
                Objects.equals(updateTime, document.updateTime);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, insertTime, updateTime);
        result = 31 * result + Arrays.hashCode(documentData);
        return result;
    }

    @ManyToOne(targetEntity = Employee.class,optional = false,cascade = {CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @JsonBackReference("documentsById")
    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "name")
    public Type getTypeByType() {
        return typeByType;
    }

    public void setTypeByType(Type typeByType) {
        this.typeByType = typeByType;
    }

    @ManyToOne
    @JoinColumn(name = "document_type", referencedColumnName = "name")
    public DocumentType getDocumentTypeByDocumentType() {
        return documentTypeByDocumentType;
    }

    public void setDocumentTypeByDocumentType(DocumentType documentTypeByDocumentType) {
        this.documentTypeByDocumentType = documentTypeByDocumentType;
    }
}
