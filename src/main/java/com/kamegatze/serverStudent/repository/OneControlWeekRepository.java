package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.OneControlWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OneControlWeekRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OneControlWeekRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<OneControlWeek> getOneControlWeek() {
        return jdbcTemplate.query("SELECT * FROM one_controll_week order by studentid;", new OneControlWeekMapping());
    }

    public OneControlWeek searchOneControlWeek(OneControlWeek oneControlWeek) {
        return jdbcTemplate.query("select * from one_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;", new OneControlWeekMapping(),
                oneControlWeek.getStudentId(),
                oneControlWeek.getSubjectId(),
                oneControlWeek.getTeacherId(),
                oneControlWeek.getSemesterId()).stream().findAny().orElse(null);
    }


    public void addOneControlWeek(OneControlWeek oneControlWeek) {
        jdbcTemplate.update("insert into one_controll_week(studentid, subjectid, teacherid, semesterid, mark) values(?, ?, ?, ?, ?)",
                oneControlWeek.getStudentId(),
                oneControlWeek.getSubjectId(),
                oneControlWeek.getTeacherId(),
                oneControlWeek.getSemesterId(),
                oneControlWeek.getMark()
        );
    }

    public void updateOneControlWeek(OneControlWeek oneControlWeek) {
        jdbcTemplate.update("update one_controll_week set mark=? where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                oneControlWeek.getMark(),
                oneControlWeek.getStudentId(),
                oneControlWeek.getSubjectId(),
                oneControlWeek.getTeacherId(),
                oneControlWeek.getSemesterId());
    }

    public void deleteOneControlWeek(OneControlWeek oneControlWeek) {
        jdbcTemplate.update("delete from one_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                oneControlWeek.getStudentId(),
                oneControlWeek.getSubjectId(),
                oneControlWeek.getTeacherId(),
                oneControlWeek.getSemesterId()
        );
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'one_controll_week' order by ordinal_position;", String.class);
    }
}
