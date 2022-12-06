package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.FormsStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FormsStudyRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FormsStudyRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<FormsStudy> getFormsStudy() {
        return jdbcTemplate.query("select * from formstudy;", new FormsStudyMapping());
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'formstudy' order by ordinal_position;", String.class);
    }
}
