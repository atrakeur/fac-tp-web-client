package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class CV_Name {

    private String name;

    private boolean maiden;

    public CV_Name() {
    }

    public CV_Name(String name, boolean maiden) {
        this.name = name;
        this.maiden = maiden;
    }

    public String getName() {
        return name;
    }

    @XmlValue
    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaiden() {
        return maiden;
    }

    @XmlAttribute
    public void setMaiden(boolean maiden) {
        this.maiden = maiden;
    }
}
