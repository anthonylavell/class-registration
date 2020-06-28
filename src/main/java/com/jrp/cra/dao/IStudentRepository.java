package com.jrp.cra.dao;

import com.jrp.cra.dto.IStudentCourse;
import com.jrp.cra.entites.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apistudents",path = "apistudents")
public interface IStudentRepository extends PagingAndSortingRepository<Student,Long> {
    @Override
    public List<Student> findAll();

    @Query(nativeQuery = true, value = "SELECT s.first_name as firstName, s.last_name as lastName, COUNT(cs.student_id) as courseCount " +
            "FROM student s left join course_student cs ON cs.student_id = s.student_id " +
            "GROUP BY s.first_name, s.last_name " +
            "ORDER BY 3 DESC")
    public List<IStudentCourse> studentCourses();

    public Student findByEmail(String value);
}
