package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.GroupFaculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupFacultyMapping implements RowMapper<GroupFaculty> {
    @Override
    public GroupFaculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        GroupFaculty groupFaculty = new GroupFaculty(
                rs.getInt("gpid"),
                rs.getString("title"),
                rs.getInt("specializationid")
        );

        return groupFaculty;
    }
}
