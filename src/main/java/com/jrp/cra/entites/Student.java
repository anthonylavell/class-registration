package com.jrp.cra.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private String Classification; //Freshman, Sophomore, Junior and Senior

    public Student(){

    }

    public Student(String firstName, String lastName, int age, String email,
                   String classification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Classification = classification;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassification() {
        return Classification;
    }

    public void setClassification(String classification) {
        Classification = classification;
    }
}
