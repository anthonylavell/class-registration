package com.jrp.cra.services;

import com.jrp.cra.dao.IStudentRepository;
import com.jrp.cra.dto.IStudentCourse;
import com.jrp.cra.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepository studentRepo;

    public Student save(Student student){
        return studentRepo.save(student);

    }

    public List<Student> getAll(){
        return studentRepo.findAll();
    }

    public List<IStudentCourse> studentCourses(){
        return studentRepo.studentCourses();
    }
}
