package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubjectRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Subject> getSubject() {
        return jdbcTemplate.query("SELECT * FROM SUBJECT order by sbid;", new SubjectMapping());
    }

    public Subject getSubjectId(int id) {
        return jdbcTemplate.query("SELECT * FROM SUBJECT WHERE SBID=?;", new Object[] {id}, new SubjectMapping()).stream().findAny().orElse(null);
    }

    public void addSubject(Subject subject) {
        jdbcTemplate.update("INSERT INTO SUBJECT(TITLE) VALUES(?);",
                subject.getTitle()
        );
    }

    public void deleteSubject(int id) {
        jdbcTemplate.update("DELETE FROM SUBJECT WHERE SBID=?", id);
    }

    public void updateSubject(Subject subject, int id) {
        jdbcTemplate.update("UPDATE SUBJECT SET TITLE=? WHERE SBID=?",
                subject.getTitle(),
                id
        );
    }

    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'subject' order by ordinal_position;", String.class);
    }
}
