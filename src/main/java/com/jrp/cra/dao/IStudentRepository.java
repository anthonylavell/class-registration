package com.jrp.cra.dao;

import com.jrp.cra.entites.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student,Long> {
}
