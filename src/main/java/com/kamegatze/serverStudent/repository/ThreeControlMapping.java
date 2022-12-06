package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.ThreeControlWeek;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThreeControlMapping implements RowMapper<ThreeControlWeek> {
    @Override
    public ThreeControlWeek mapRow(ResultSet rs, int rowNum) throws SQLException {
        ThreeControlWeek threeControlWeek = new ThreeControlWeek(
                rs.getInt("studentid"),
                rs.getInt("subjectid"),
                rs.getInt("teacherid"),
                rs.getInt("semesterid"),
                rs.getDouble("mark")
        );

        return threeControlWeek;
    }
}
