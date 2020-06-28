package com.jrp.cra.services;

import com.jrp.cra.dao.ICourseRepository;
import com.jrp.cra.entites.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    ICourseRepository courseRepo;

    public Course save(Course course){
        return courseRepo.save(course);

    }

    public List<Course> getAll(){
        return courseRepo.findAll();
    }

    public Course getCourseById(long id){
        return courseRepo.findById(id).get();
    }

    public void deleteCourseById(long id){
        courseRepo.deleteById(id);
    }

}
