package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Semesters;
import com.kamegatze.serverStudent.repository.SemestersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;


@RestController
@RequestMapping("/semesters")
@CrossOrigin
public class SemestersController {
    private final SemestersRepository semestersRepository;

    @Autowired
    public SemestersController(SemestersRepository semestersRepository) {
        this.semestersRepository = semestersRepository;
    }
    @GetMapping()
    public List<Semesters> getSemesters() {
        return semestersRepository.getSemesters();
    }
}
