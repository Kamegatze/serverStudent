package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.TwoControlWeek;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TwoControlWeekMapping implements RowMapper<TwoControlWeek> {
    @Override
    public TwoControlWeek mapRow(ResultSet rs, int rowNum) throws SQLException {
        TwoControlWeek twoControlWeek = new TwoControlWeek(
                rs.getInt("studentid"),
                rs.getInt("subjectid"),
                rs.getInt("teacherid"),
                rs.getInt("semesterid"),
                rs.getDouble("mark")
        );

        return twoControlWeek;
    }
}
