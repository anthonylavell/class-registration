package com.jrp.cra.api;

import com.jrp.cra.entites.Course;
import com.jrp.cra.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/app-api/courses")
public class CourseApiController {

    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable("id") long id){
        return courseService.getCourseById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course){
       return courseService.save(course);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Course update(@RequestBody @Valid Course course){
        return courseService.save(course);
    }

    @PatchMapping(path = "/{id}",consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Course partialUpdated(@PathVariable("id") long id,
                                 @RequestBody @Valid Course patchCourse){

        Course course  = courseService.getCourseById(id);
        if(patchCourse.getCourseCredit() > 0){
            course.setCourseCredit(patchCourse.getCourseCredit());
        }
        if(patchCourse.getCourseName()!= null){
            course.setCourseName(patchCourse.getCourseName());
        }
        if(patchCourse.getDescription() != null ){
            course.setDescription(patchCourse.getDescription());
        }
        if(patchCourse.getStage() != null ){
            course.setStage(patchCourse.getStage());
        }

        return courseService.save(course);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable("id") long id){
        try {
            courseService.deleteCourseById(id);
        }catch (EmptyResultDataAccessException e){

        }

    }

}
