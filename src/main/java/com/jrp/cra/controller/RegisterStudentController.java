package com.jrp.cra.controller;

import com.jrp.cra.entites.Student;
import com.jrp.cra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/register")
    public String displayForm(Model model){
        Student aStudent = new Student();
        model.addAttribute("student",aStudent);
        return "student/register-student";
    }

    @PostMapping("/save")
    public String registerStudent( Student student ,Model model){
        studentRepo.save(student);
        return "redirect:/student";

    }

}
