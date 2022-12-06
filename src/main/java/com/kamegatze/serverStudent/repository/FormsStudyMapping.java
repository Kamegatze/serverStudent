package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.FormsStudy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FormsStudyMapping implements RowMapper<FormsStudy> {
    @Override
    public FormsStudy mapRow(ResultSet rs, int rowNum) throws SQLException {
        FormsStudy formsStudy = new FormsStudy(
                rs.getInt("fsid"),
                rs.getString("title")
        );

        return formsStudy;
    }
}
