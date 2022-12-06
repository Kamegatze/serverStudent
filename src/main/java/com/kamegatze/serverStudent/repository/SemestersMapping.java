package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Semesters;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SemestersMapping implements RowMapper<Semesters> {
    @Override
    public Semesters mapRow(ResultSet rs, int rowNum) throws SQLException {
        Semesters semesters = new Semesters(
                rs.getInt("semester"),
                rs.getString("title")
        );

        return semesters;
    }
}
