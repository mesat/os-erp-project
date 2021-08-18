package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Document;
import com.proline.OsErpProline.entity.DocumentType;
import com.proline.OsErpProline.entity.Type;

import java.io.Serializable;
import java.util.Base64;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public class DocumentDto implements Serializable {
    private String type;
    private String documentType;
    private String document;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Document toDocument() {
        Document document = new Document();
        document.setDocumentData(Base64.getDecoder().decode(this.document));
        document.setDocumentTypeByDocumentType(new DocumentType());
        document.getDocumentTypeByDocumentType().setName(this.documentType);
        document.setTypeByType(new Type());
        document.getTypeByType().setName(this.type);
        return document;
    }
}
