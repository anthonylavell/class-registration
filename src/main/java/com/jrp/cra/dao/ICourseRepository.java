package com.jrp.cra.dao;

import com.jrp.cra.dto.IChartData;
import com.jrp.cra.entites.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "apicourses",path = "apicourses")
public interface ICourseRepository extends PagingAndSortingRepository<Course, Long> {

    @Override
    public List<Course> findAll();



    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value " +
            "FROM course " +
            "GROUP BY stage")
    public List<IChartData> getCourseStatus();
}
