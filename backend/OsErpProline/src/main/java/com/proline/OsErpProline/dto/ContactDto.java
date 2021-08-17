package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Contact;

import java.io.Serializable;
import java.util.stream.Stream;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public class ContactDto implements Serializable {
    private String link;
    private SocialmediaDto socialmediaBySocialmediaPlatform;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public SocialmediaDto getSocialmediaBySocialmediaPlatform() {
        return socialmediaBySocialmediaPlatform;
    }

    public void setSocialmediaBySocialmediaPlatform(SocialmediaDto socialmediaBySocialmediaPlatform) {
        this.socialmediaBySocialmediaPlatform = socialmediaBySocialmediaPlatform;
    }

    //todo: mapping
    public Contact toContact() {
        return null;
    }
}
