package com.jrp.cra.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    private long courseCredit;
    private String courseName;
    private String stage; // EMPTY, FULL, ALMOST FULL
    private String description;

    public Course(){

    }

    public Course(long courseCredit, String courseName, String stage,
                  String description) {
        this.courseCredit = courseCredit;
        this.courseName = courseName;
        this.stage = stage;
        this.description = description;
    }

    public long getRegistrationId() {
        return courseId;
    }

    public void setRegistrationId(long courseId) {
        this.courseId = courseId;
    }

    public long getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(long courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
