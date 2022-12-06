package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.GroupFaculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class GroupFacultyRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GroupFacultyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<GroupFaculty> getGroupFaculty() {
        return jdbcTemplate.query("select * from group_faculty order by title;", new GroupFacultyMapping());
    }

    public GroupFaculty getGroupFacultyID(int id) {
        return jdbcTemplate.query("select * from group_faculty where gpid = ?", new GroupFacultyMapping(), id)
                .stream().findAny().orElse(null);
    }

    public void createGroupFaculty(GroupFaculty groupFaculty) {
        jdbcTemplate.update("insert into group_faculty (title, specializationid) values (?, ?);", groupFaculty.getTitle(), groupFaculty.getSpecializationId());
    }

    public void updateGroupFaculty(GroupFaculty groupFaculty) {
        jdbcTemplate.update("update group_faculty set title=?, specializationid=? where gpid=?;",
                groupFaculty.getTitle(),
                groupFaculty.getSpecializationId(),
                groupFaculty.getId()
        );
    }
    public void deleteGroupFaculty(int id) {
        jdbcTemplate.update("delete from group_faculty where gpid=?", id);
    }

    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'group_faculty' order by ordinal_position;", String.class);
    }

}
