package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="cv_list")
public class CVList {

    private List<CV> listCV;

    public CVList() {
        this.listCV = new ArrayList<CV>();
    }

    public List<CV> getListCV() {
        return listCV;
    }

    @XmlElement(name = "cv")
    public void setListCV(List<CV> listCV) {
        this.listCV = listCV;
    }
}
