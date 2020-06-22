package com.jrp.cra.dao;

import com.jrp.cra.entites.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
@SqlGroup({@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts =
        {"classpath:schema.sql", "classpath:data.sql"}),@Sql(executionPhase =
        Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts ="drop.sql")})
public class CourseRepositoryIntegrationTest {

    @Autowired
    ICourseRepository courseRepo;

    @Autowired
    IStudentRepository studentRepo;

    @Test
    public void ifNewCourseSaved_thenSuccess(){
        Course newCourse = new Course("Communication 101", 4, "Empty","Great course to " +
                "take");
        courseRepo.save(newCourse);

        assertEquals(5,courseRepo.findAll().size());
    }

}
