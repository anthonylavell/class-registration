package com.jrp.cra.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentId;

    @NotBlank(message="*Must give a first name")
    @Size(min = 1, max = 50)
    private String firstName;

    @NotBlank(message="*Must give a last name")
    @Size(min = 2, max = 50)
    private String lastName;
    private int age;

    @NotBlank
    @Email(message="*Must be a valid email address")
    private String email;

    @NotBlank(message="*Must give a classification")
    private String classification; //Freshman, Sophomore, Junior and Senior

    public Student(){

    }

    public Student(String firstName, String lastName, int age, String email,
                   String classification) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.classification = classification;
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
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
