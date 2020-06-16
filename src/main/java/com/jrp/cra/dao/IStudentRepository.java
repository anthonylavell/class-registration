package com.jrp.cra.dao;

import com.jrp.cra.dto.IStudentCourse;
import com.jrp.cra.entites.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<Student,Long> {
    @Override
    public List<Student> findAll();

    @Query(nativeQuery = true, value = "SELECT s.first_name as firstName, s.last_name as lastName, COUNT(cs.student_id) as courseCount " +
            "FROM student s left join course_student cs ON cs.student_id = s.student_id " +
            "GROUP BY s.first_name, s.last_name " +
            "ORDER BY 3 DESC")
    public List<IStudentCourse> studentCourses();
}
