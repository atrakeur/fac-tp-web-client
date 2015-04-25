package com.atrakeur.web.restclient.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cv")
@XmlType(propOrder={"id", "gender", "name", "firstname", "objective", "experiences", "schools", "skill", "langues", "computerSkill"})
public class CV {

    private String id;
    private String gender;
    private CV_Name name;
    private String firstname;

    private String objective;
    private List<CV_Experience> experiences = new ArrayList<>();
    private List<CV_School> schools = new ArrayList<>();

    private String skill;

    private List<CV_Lang> langues = new ArrayList<>();
    private List<CV_ComputerSkill> computerSkill = new ArrayList<>();

    public CV() {
        super();
    }

    public CV(String id, String gender, CV_Name name, String firstname, String objective, List<CV_Experience> experiences, List<CV_School> schools, String skill, List<CV_Lang> langues, List<CV_ComputerSkill> computerSkill) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.firstname = firstname;
        this.objective = objective;
        this.experiences = experiences;
        this.schools = schools;
        this.skill = skill;
        this.langues = langues;
        this.computerSkill = computerSkill;
    }

    public String getId() {
        return id;
    }

    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    @XmlElement(name="first_name")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public CV_Name getName() {
        return name;
    }

    @XmlElement
    public void setName(CV_Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    @XmlElement
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getObjective() {
        return objective;
    }

    @XmlElement
    public void setObjective(String objective) {
        this.objective = objective;
    }

    public List<CV_Experience> getExperiences() {
        return experiences;
    }

    @XmlElement(name = "experience")
    public void setExperiences(List<CV_Experience> experiences) {
        this.experiences = experiences;
    }

    public List<CV_School> getSchools() {
        return schools;
    }

    @XmlElement(name = "school")
    public void setSchools(List<CV_School> schools) {
        this.schools = schools;
    }

    public String getSkill() {
        return skill;
    }

    @XmlElement
    public void setSkill(String skill) {
        this.skill = skill;
    }

    public List<CV_Lang> getLangues() {
        return langues;
    }

    @XmlElement(name = "language")
    public void setLangues(List<CV_Lang> langues) {
        this.langues = langues;
    }

    public List<CV_ComputerSkill> getComputerSkill() {
        return computerSkill;
    }

    @XmlElement(name = "computer_sciences_skill")
    public void setComputerSkill(List<CV_ComputerSkill> computerSkill) {
        this.computerSkill = computerSkill;
    }
}
