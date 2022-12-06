package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Semesters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class SemestersRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SemestersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Semesters> getSemesters() {
        return jdbcTemplate.query("select * from semesters", new SemestersMapping());
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'semesters' order by ordinal_position;", String.class);
    }
}
