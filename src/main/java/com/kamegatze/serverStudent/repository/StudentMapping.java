package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapping implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student(
                rs.getInt("stid"),
                rs.getString("lastname"),
                rs.getString("firstname"),
                rs.getString("patronymic"),
                rs.getInt("formstudyid"),
                rs.getInt("groupid"),
                rs.getString("email")
        );

        return student;
    }
}
