package com.jrp.cra.api;

import com.jrp.cra.entites.Student;
import com.jrp.cra.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app-api/students")
public class StudentApiController {
    @Autowired
    StudentService studentService;

    /*@Autowired
    IStudentRepository studentRepo;*/

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student){
       return studentService.save(student);
    }

    @PutMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student){
        int n;
        return studentService.save(student);
    }

    @PatchMapping(path = "/{id}", consumes = "application/json")
    public Student partialUpdate(@PathVariable("id") long id,
                                 @RequestBody Student patchStudent){

        Student student  = studentService.getStudentById(id);
        if(patchStudent.getFirstName() != null){
            student.setFirstName(patchStudent.getFirstName());
        }
        if(patchStudent.getLastName() != null){
            student.setLastName(patchStudent.getLastName());
        }
        if(patchStudent.getAge() > 0 ){
            student.setAge(patchStudent.getAge());
        }
        if(patchStudent.getClassification() != null ){
            student.setClassification(patchStudent.getClassification());
        }
        if(patchStudent.getEmail()!= null ){
            student.setEmail(patchStudent.getEmail());
        }
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        try {
            studentService.deleteStudentById(id);
        }catch (EmptyResultDataAccessException e){

        }

    }
}
