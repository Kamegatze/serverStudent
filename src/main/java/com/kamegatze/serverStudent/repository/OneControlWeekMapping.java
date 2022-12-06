package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.OneControlWeek;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OneControlWeekMapping implements RowMapper<OneControlWeek> {
    @Override
    public OneControlWeek mapRow(ResultSet rs, int rowNum) throws SQLException {
        OneControlWeek oneControlWeek = new OneControlWeek(
                rs.getInt("studentid"),
                rs.getInt("subjectid"),
                rs.getInt("teacherid"),
                rs.getInt("semesterid"),
                rs.getDouble("mark")
        );

        return oneControlWeek;
    }
}
