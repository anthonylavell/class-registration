package com.jrp.cra.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @SequenceGenerator(name = "get_course_seq", sequenceName = "course_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "get_course_seq")
    private long courseId;

    @Max(value = 12, message = "*Course Credit can not greater than 20")
    @Min(value = 1, message = "*Course Credit can not less than 1")
    private long courseCredit;

    @NotBlank(message="*Must give a last name")
    private String courseName;

    @NotBlank(message="*Must give a last name")
    private String stage; // EMPTY, FULL, ALMOST FULL

    @NotBlank(message="*Must give a last name")
    private String description;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="course_student", joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<Student> students;

    public Course(){

    }

    public Course(String courseName, long courseCredit, String stage,
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

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
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

    public void addStudent(Student student){
        if(students==null){
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
