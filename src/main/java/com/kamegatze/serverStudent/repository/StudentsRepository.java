package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentsRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Student> getStudents() {
        return jdbcTemplate.query("SELECT * FROM STUDENTS order by stid;", new StudentMapping());
    }

    public Student getStudent(int id) {
        return jdbcTemplate.query("SELECT * FROM STUDENTS WHERE STID=?;", new StudentMapping(), id).stream().findAny().orElse(null);
    }

    public void addStudent(Student student) {
        jdbcTemplate.update("INSERT INTO STUDENTS(LASTNAME, FIRSTNAME, PATRONYMIC, FORMSTUDYID, GROUPID, email) VALUES(?, ?, ?, ?, ?, ?);",
                student.getLastName(),
                student.getFirstName(),
                student.getPatronymic(),
                student.getFormStudyId(),
                student.getGroupId(),
                student.getEmail()
                );
    }

    public void deleteStudent(int id) {
        jdbcTemplate.update("DELETE FROM STUDENTS WHERE STID=?", id);
    }

    public void updateStudent(Student student, int id) {
        jdbcTemplate.update("UPDATE STUDENTS SET LASTNAME=?, FIRSTNAME=?, PATRONYMIC=?, FORMSTUDYID=?, GROUPID=? WHERE STID=?",
                student.getLastName(),
                student.getFirstName(),
                student.getPatronymic(),
                student.getFormStudyId(),
                student.getGroupId(),
                id
                );
    }

    public List<String> getField() {
        return jdbcTemplate.queryForList("select column_name from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'students'\n" +
                "order by ordinal_position;", String.class);
    }
}
