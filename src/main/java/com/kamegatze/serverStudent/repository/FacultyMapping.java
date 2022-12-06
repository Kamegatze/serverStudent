package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapping implements RowMapper<Faculty> {
    @Override
    public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty(
              rs.getInt("facid"),
              rs.getString("title")
        );

        return faculty;
    }
}
