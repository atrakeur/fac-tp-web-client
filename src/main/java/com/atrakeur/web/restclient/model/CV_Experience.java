package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.Date;

@XmlRootElement(name = "experience")
public class CV_Experience {

    private String text;

    private Date begin;

    private Date end;

    public CV_Experience() {
    }

    public CV_Experience(String text, Date begin, Date end) {
        this.text  = text;
        this.begin = begin;
        this.end   = end;
    }

    public String getText() {
        return text;
    }

    @XmlValue
    public void setText(String text) {
        this.text = text;
    }

    public Date getBegin() {
        return begin;
    }

    @XmlAttribute
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    @XmlAttribute
    public void setEnd(Date end) {
        this.end = end;
    }
}
