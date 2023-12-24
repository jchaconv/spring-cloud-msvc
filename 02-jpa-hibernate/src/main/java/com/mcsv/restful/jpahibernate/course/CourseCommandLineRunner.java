package com.mcsv.restful.jpahibernate.course;

import com.mcsv.restful.jpahibernate.course.jdbc.JdbcRepository;
import com.mcsv.restful.jpahibernate.course.jpa.CourseJpaRepository;
import com.mcsv.restful.jpahibernate.course.model.Course;
import com.mcsv.restful.jpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    /*private final JdbcRepository repository;

    public CourseCommandLineRunner(JdbcRepository repository) {
        this.repository = repository;
    }*/

    /*private final CourseJpaRepository repository;

    public CourseCommandLineRunner(CourseJpaRepository repository) {
        this.repository = repository;
    }*/

    private CourseSpringDataJpaRepository repository;

    public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        //repository.insert();
        /*repository.insertDynamic(new Course(1, "Learn Google Cloud Platform", "in28Minutes"));
        repository.insertDynamic(new Course(2, "Learn AWS", "in28Minutes"));
        repository.insertDynamic(new Course(3, "Learn Azure", "in28Minutes"));

        repository.deleteDynamic(2);

        System.out.println(repository.selectDynamic(1));
        System.out.println(repository.selectDynamic(3));*/

        /*repository.insert(new Course(1, "Learn Google Cloud Platform", "in28Minutes"));
        repository.insert(new Course(2, "Learn AWS", "in28Minutes"));
        repository.insert(new Course(3, "Learn Azure", "in28Minutes"));

        repository.deleteById(2);

        System.out.println(repository.findById(1));
        System.out.println(repository.findById(3));*/

        repository.save(new Course(1, "Learn Google Cloud Platform", "in28Minutes"));
        repository.save(new Course(2, "Learn AWS", "in28Minutes"));
        repository.save(new Course(3, "Learn Azure", "in28Minutes"));
        repository.save(new Course(4, "Spring Webflux and microservice", "Vinoth Selvaraj"));

        repository.deleteById(2L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(3L));

        System.out.println("=====================");

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("in28Minutes"));


    }

}
