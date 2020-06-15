package com.jrp.cra.controller;

import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.dao.IStudentRepository;
import com.jrp.cra.entites.Course;
import com.jrp.cra.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ICourseRepository courseRepo;
    @Autowired
    IStudentRepository studentRepo;

    @GetMapping("/")
    public String displayHome(Model model){
       model.addAttribute("versionNumber",ver);

        List<Course> listOfCourses = courseRepo.findAll();
        model.addAttribute("courses",listOfCourses);

        List<Student> listOfStudents = studentRepo.findAll();
        model.addAttribute("students",listOfStudents);

        return "main/home";
    }
}
