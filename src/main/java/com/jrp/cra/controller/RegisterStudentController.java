package com.jrp.cra.controller;

import com.jrp.cra.entites.Student;
import com.jrp.cra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/student")
public class RegisterStudentController {

    @Autowired
    StudentService studentRepo;

    @GetMapping
    public String displayStudents(Model model){
        List<Student> listOfStudents = studentRepo.getAll();
        model.addAttribute("students",listOfStudents);
        return "student/list-students";
    }

    @GetMapping("/registration")
    public String displayForm(Model model){
        Student aStudent = new Student();
        model.addAttribute("student",aStudent);
        return "student/register-student";
    }

    @PostMapping("/save")
    public String registerStudent(Model model, @Valid Student student, Errors errors){
        if(errors.hasErrors() ){
            return "student/register-student";
        }
        studentRepo.save(student);
        return "redirect:/student";

    }

    @GetMapping("/update")
    public String displayStudentUpdateForm(@RequestParam("id") long theId, Model model){
       Student student= studentRepo.getStudentById(theId);
       model.addAttribute("student",student);
        return "student/register-student";
    }

    @GetMapping("/delete")
    public String displayStudentDeleteForm(@RequestParam("id") long theId){
        studentRepo.deleteStudentById(theId);
        return "redirect:/student";
    }

}
