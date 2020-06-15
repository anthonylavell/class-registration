package com.jrp.cra.entites;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long courseId;

    private long courseCredit;
    private String courseName;
    private String stage; // EMPTY, FULL, ALMOST FULL
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="course_student", joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course(){

    }

    public Course(long courseCredit, String courseName, String stage,
                  String description) {
        this.courseCredit = courseCredit;
        this.courseName = courseName;
        this.stage = stage;
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
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
