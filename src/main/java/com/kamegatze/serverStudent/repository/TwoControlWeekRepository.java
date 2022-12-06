package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.TwoControlWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TwoControlWeekRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TwoControlWeekRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<TwoControlWeek> getTwoControlWeek() {
        return jdbcTemplate.query("SELECT * FROM two_controll_week order by studentid;", new TwoControlWeekMapping());
    }

    public TwoControlWeek searchTwoControlWeek(TwoControlWeek twoControlWeek) {
        return jdbcTemplate.query("select * from two_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;", new TwoControlWeekMapping(),
                twoControlWeek.getStudentId(),
                twoControlWeek.getSubjectId(),
                twoControlWeek.getTeacherId(),
                twoControlWeek.getSemesterId()).stream().findAny().orElse(null);
    }

    public void addTwoControlWeek(TwoControlWeek twoControlWeek) {
        jdbcTemplate.update("insert into two_controll_week(studentid, subjectid, teacherid, semesterid, mark) values(?, ?, ?, ?, ?)",
                twoControlWeek.getStudentId(),
                twoControlWeek.getSubjectId(),
                twoControlWeek.getTeacherId(),
                twoControlWeek.getSemesterId(),
                twoControlWeek.getMark()
                );
    }

    public void updateTwoControlWeek(TwoControlWeek twoControlWeek) {
        jdbcTemplate.update("update two_controll_week set mark=? where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                twoControlWeek.getMark(),
                twoControlWeek.getStudentId(),
                twoControlWeek.getSubjectId(),
                twoControlWeek.getTeacherId(),
                twoControlWeek.getSemesterId());
    }

    public void deleteTwoControlWeek(TwoControlWeek twoControlWeek) {
        jdbcTemplate.update("delete from two_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                twoControlWeek.getStudentId(),
                twoControlWeek.getSubjectId(),
                twoControlWeek.getTeacherId(),
                twoControlWeek.getSemesterId()
        );
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'two_controll_week' order by ordinal_position;", String.class);
    }
}
