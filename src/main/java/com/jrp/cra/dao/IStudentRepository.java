package com.jrp.cra.dao;

import com.jrp.cra.entites.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<Student,Long> {
    @Override
    public List<Student> findAll();
}
