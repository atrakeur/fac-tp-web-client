package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.XmlAttribute;

public class CV_ComputerSkill {

    private String name;
    private int level;

    public CV_ComputerSkill() {
    }

    public CV_ComputerSkill(String name, int level) {
        this.name = name;
        this.level = level;
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

}
