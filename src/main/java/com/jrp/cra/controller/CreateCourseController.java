package com.jrp.cra.controller;

import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course")
public class CreateCourseController {

    @Autowired
    ICourseRepository courseRep;

    @GetMapping("/new")
    public String displayForm(Model model){
        Course aCourse = new Course();
        model.addAttribute("course",aCourse);
        return "course/new-course";
    }

    @PostMapping("/save")
    public String createCourse(Course course, Model model){
        courseRep.save(course);
        // use a redirect to prevent duplicate submissions
        return "redirect:/course/new";
    }
}
