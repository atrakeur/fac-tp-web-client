package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CV_Lang {

    private String name;
    private int level;
    private String description;

    public CV_Lang() {
    }

    public CV_Lang(String name, int level, String description) {
        this.name = name;
        this.level = level;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    @XmlAttribute
    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }
}
