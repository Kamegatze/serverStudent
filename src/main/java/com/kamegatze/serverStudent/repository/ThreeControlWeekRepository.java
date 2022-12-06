package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.ThreeControlWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThreeControlWeekRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ThreeControlWeekRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ThreeControlWeek> getThreeControlWeek() {
        return jdbcTemplate.query("SELECT * FROM three_controll_week order by studentid;", new ThreeControlMapping());
    }

    public ThreeControlWeek searchThreeControlWeek(ThreeControlWeek threeControlWeek) {
        return jdbcTemplate.query("select * from three_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;", new ThreeControlMapping(),
                threeControlWeek.getStudentId(),
                threeControlWeek.getSubjectId(),
                threeControlWeek.getTeacherId(),
                threeControlWeek.getSemesterId()).stream().findAny().orElse(null);
    }

    public void addThreeControlWeek(ThreeControlWeek threeControlWeek) {
        jdbcTemplate.update("insert into three_controll_week(studentid, subjectid, teacherid, semesterid, mark) values(?, ?, ?, ?, ?)",
                threeControlWeek.getStudentId(),
                threeControlWeek.getSubjectId(),
                threeControlWeek.getTeacherId(),
                threeControlWeek.getSemesterId(),
                threeControlWeek.getMark()
        );
    }

    public void updateThreeControlWeek(ThreeControlWeek threeControlWeek) {
        jdbcTemplate.update("update three_controll_week set mark=? where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                threeControlWeek.getMark(),
                threeControlWeek.getStudentId(),
                threeControlWeek.getSubjectId(),
                threeControlWeek.getTeacherId(),
                threeControlWeek.getSemesterId());
    }

    public void deleteThreeControlWeek(ThreeControlWeek threeControlWeek) {
        jdbcTemplate.update("delete from three_controll_week where studentid=? and subjectid=? and teacherid=? and semesterid=?;",
                threeControlWeek.getStudentId(),
                threeControlWeek.getSubjectId(),
                threeControlWeek.getTeacherId(),
                threeControlWeek.getSemesterId()
        );
    }
    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'three_controll_week' order by ordinal_position;", String.class);
    }
}
