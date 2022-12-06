package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class TeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> getTeachers() {
        return jdbcTemplate.query("select * from teacher order by teachid;", new TeacherMapping());
    }

    public Teacher getTeacher(int id) {
        return jdbcTemplate.query("select * from teacher where teachid=?", new TeacherMapping(), id)
                .stream().findAny().orElse(null);
    }

    public void createTeacher(Teacher teacher) {
        jdbcTemplate.update("insert into teacher (lastname, firstname, patronymic, email) values (?, ?, ?, ?);",
                teacher.getLastName(),
                teacher.getFirstName(),
                teacher.getPatronymic(),
                teacher.getEmail()
        );
    }

    public void updateTeacher(Teacher teacher) {
        jdbcTemplate.update("update teacher set lastname=?, firstname=?, patronymic=?, email=? where teachid=?",
                teacher.getLastName(),
                teacher.getFirstName(),
                teacher.getPatronymic(),
                teacher.getEmail(),
                teacher.getId()
        );
    }

    public void deleteTeacher(int id) {
        jdbcTemplate.update("delete from teacher where teachid=?", id);
    }

    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'teacher' order by ordinal_position;", String.class);
    }
}
