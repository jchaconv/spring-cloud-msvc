package com.mcsv.restful.jpahibernate.course.jdbc;

import com.mcsv.restful.jpahibernate.course.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY_STATIC = "INSERT INTO COURSE (id, name, author)\n" +
            "VALUES(1, 'Learn AWS', 'in28minutes');";

    private static final String INSERT_QUERY_DYNAMIC = "INSERT INTO COURSE (id, name, author) VALUES(?,?,?);";
    public static final String DELETE_QUERY_DYNAMIC = "DELETE FROM COURSE WHERE id=?;";
    public static final String SELECT_QUERY_DYNAMIC = "SELECT * FROM COURSE WHERE id=?;";

    public void insert() {
        jdbcTemplate.update(INSERT_QUERY_STATIC);
    }

    public void insertDynamic(Course course) {
        jdbcTemplate.update(INSERT_QUERY_DYNAMIC, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteDynamic(long idCourse) {
        jdbcTemplate.update(DELETE_QUERY_DYNAMIC, idCourse);
    }

    public Course selectDynamic(long idCourse) {
        //ResultSet -> Bean (Row Mapper)
        return jdbcTemplate.queryForObject(SELECT_QUERY_DYNAMIC,
                new BeanPropertyRowMapper<>(Course.class), idCourse);
    }

}
