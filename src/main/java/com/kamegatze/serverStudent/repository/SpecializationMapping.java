package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Specialization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpecializationMapping implements RowMapper<Specialization> {
    @Override
    public Specialization mapRow(ResultSet rs, int rowNum) throws SQLException {
        Specialization specialization = new Specialization(
                rs.getInt("spid"),
                rs.getString("title"),
                rs.getInt("facultyid")
        );

        return specialization;
    }
}
