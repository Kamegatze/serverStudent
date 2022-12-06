package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class FacultyRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FacultyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Faculty> getFaculty() {
        return jdbcTemplate.query("SELECT * FROM FACULTY order by facid;", new FacultyMapping());
    }


    public void addFaculty(Faculty faculty) {
        jdbcTemplate.update("insert into faculty(title) values(?)", faculty.getTitle());
    }

    public void updateFaculty(Faculty faculty) {
        jdbcTemplate.update("update faculty set title=? where facid=?;", faculty.getTitle(), faculty.getId());
    }

    public void deleteFaculty(int id) {
        jdbcTemplate.update("delete from faculty where facid=?", id);
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'faculty'order by ordinal_position;", String.class);
    }
}
