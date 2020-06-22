package com.jrp.cra.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.dao.IStudentRepository;
import com.jrp.cra.dto.IChartData;
import com.jrp.cra.dto.IStudentCourse;
import com.jrp.cra.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ICourseRepository courseRepo;
    @Autowired
    IStudentRepository studentRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
       model.addAttribute("versionNumber",ver);

       // querying the database for course
        List<Course> listOfCourses = courseRepo.findAll();
        model.addAttribute("courses",listOfCourses);

        List<IChartData> courseData = courseRepo.getCourseStatus();

        // Lets convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(courseData);
        //["Empty", 1], ["Almost-Full", 1] , ["Full", 2]
        model.addAttribute("courseCapacityCnt",jsonString);

        List<IStudentCourse> studentsCourseCnt = studentRepo.studentCourses();
        model.addAttribute("studentsCourseCnt",studentsCourseCnt);

        return "main/home";
    }
}
