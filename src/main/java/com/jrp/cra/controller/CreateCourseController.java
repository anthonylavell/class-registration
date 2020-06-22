package com.jrp.cra.controller;

import com.jrp.cra.entites.Course;
import com.jrp.cra.entites.Student;
import com.jrp.cra.services.CourseService;
import com.jrp.cra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CreateCourseController {

    @Autowired
    CourseService courseRep;

    @Autowired
    StudentService studentRep;

    @GetMapping
    public String displayStudents(Model model){
        List<Course> listOfCourse = courseRep.getAll();
        model.addAttribute("courses",listOfCourse);
        return "course/list-courses";
    }

    @GetMapping("/new")
    public String displayForm(Model model){
        Course aCourse = new Course();
        model.addAttribute("course",aCourse);

        List<Student>listOfStudents = studentRep.getAll();
        model.addAttribute("allStudents", listOfStudents);
        return "course/new-course";
    }

    @PostMapping("/save")
    public String createCourse(Course course, Model model){
        courseRep.save(course);



        // use a redirect to prevent duplicate submissions
        return "redirect:/course";
    }
}
