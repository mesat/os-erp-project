package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Contact;
import com.proline.OsErpProline.entity.DocumentType;
import com.proline.OsErpProline.entity.Employee;
import com.proline.OsErpProline.entity.Socialmedia;

import java.io.Serializable;
import java.util.stream.Collectors;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public class ContactDto implements Serializable {
    private String link;
    private String nick;
    private SocialmediaDto socialmedia;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public SocialmediaDto getSocialmedia() {
        return socialmedia;
    }

    public void setSocialmedia(SocialmediaDto socialmedia) {
        this.socialmedia = socialmedia;
    }

    //todo: mapping
    public Contact toContact() {
        Contact contact = new Contact();

        contact.setLink(this.link);
        contact.setNick(this.nick);

        contact.setSocialmediaBySocialmediaPlatform(this.socialmedia.toSocialmedia());

        return contact;
    }
}
