package com.mcsv.restful.jpahibernate.course.springdatajpa;

import com.mcsv.restful.jpahibernate.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

    List<Course> findByAuthor(String author);


}
