package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Subject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapping implements RowMapper<Subject> {
    @Override
    public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {
        Subject subject = new Subject(
                rs.getInt("sbid"),
                rs.getString("title")
        );

        return subject;
    }
}
