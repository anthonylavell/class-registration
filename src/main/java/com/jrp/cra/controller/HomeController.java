package com.jrp.cra.controller;

import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ICourseRepository courseRepo;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Course> courses = courseRepo.findAll();
        model.addAttribute("courses",courses);
        return "main/home";
    }
}
