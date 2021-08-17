package com.proline.OsErpProline.dto;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public enum DocumentTypeEnum {
    JPG("JPG"),
    PDF("PDF");
    private String value;

    DocumentTypeEnum(String value) {
        this.value = value;
    }
}
