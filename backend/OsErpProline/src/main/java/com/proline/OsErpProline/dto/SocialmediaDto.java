package com.proline.OsErpProline.dto;

import com.proline.OsErpProline.entity.Socialmedia;

import java.io.Serializable;

/**
 * @author Muhammet Sakarya
 * created at 8/17/2021
 */
public class SocialmediaDto implements Serializable {
    private String platform;
    private String icon;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Socialmedia toSocialmedia(){
        Socialmedia socialmedia = new Socialmedia();

        socialmedia.setPlatform(this.platform);
        socialmedia.setIcon(this.icon);

        return socialmedia;
    }
}
