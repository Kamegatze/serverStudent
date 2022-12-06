package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapping implements RowMapper<Teacher> {
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher(
                rs.getInt("teachid"),
                rs.getString("lastname"),
                rs.getString("firstname"),
                rs.getString("patronymic"),
                rs.getString("email")
        );

        return teacher;
    }
}
