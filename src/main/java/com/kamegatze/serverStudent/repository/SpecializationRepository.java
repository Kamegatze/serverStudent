package com.kamegatze.serverStudent.repository;

import com.kamegatze.serverStudent.models.Specialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class SpecializationRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SpecializationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Specialization> getSpecializations() {
        return jdbcTemplate.query("select * from specialization order by spid;", new SpecializationMapping());
    }

    public Specialization getSpecialization(int id) {
        return jdbcTemplate.query("select * from specialization where spid=?", new SpecializationMapping(), id)
                .stream().findAny().orElse(null);
    }

    public void createSpecialization(Specialization specialization) {
        jdbcTemplate.update("insert into specialization(title, facultyid) values (?, ?);",
                specialization.getTitle(),
                specialization.getFacultyId()
        );
    }

    public void updateSpecialization(Specialization specialization) {
        jdbcTemplate.update("update specialization set title=?, facultyid=? where spid=?",
                specialization.getTitle(),
                specialization.getFacultyId(),
                specialization.getId()
        );
    }

    public void deleteSpecialization(int id) {
        jdbcTemplate.update("delete from specialization where spid=?;", id);
    }

    public List<String> getField() {
        return jdbcTemplate.queryForList("select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS\n" +
                "where TABLE_NAME = 'specialization' order by ordinal_position;", String.class);
    }
}
