package com.jrp.cra.dao;

import com.jrp.cra.entites.Course;
import org.springframework.data.repository.CrudRepository;

public interface ICourseRepository extends CrudRepository<Course, Long> {
}
