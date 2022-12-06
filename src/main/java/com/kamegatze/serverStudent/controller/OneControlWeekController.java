package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.OneControlWeek;
import com.kamegatze.serverStudent.repository.OneControlWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/oneControlWeek")
@CrossOrigin
public class OneControlWeekController {
    private final OneControlWeekRepository oneControlWeekRepository;

    @Autowired
    public OneControlWeekController(OneControlWeekRepository oneControlWeekRepository) {
        this.oneControlWeekRepository = oneControlWeekRepository;
    }

    @GetMapping()
    public List<OneControlWeek> getOneControlWeek() {
        return oneControlWeekRepository.getOneControlWeek();
    }

    @GetMapping("/search")
    public OneControlWeek searchOneControlWeek(@Valid @RequestBody OneControlWeek oneControlWeek) {
        return oneControlWeekRepository.searchOneControlWeek(oneControlWeek);
    }

    @PostMapping("/add")
    public void addOneControlWeek(@Valid @RequestBody OneControlWeek oneControlWeek) {
        oneControlWeekRepository.addOneControlWeek(oneControlWeek);
    }

    @PatchMapping("/update")
    public void updateOneControlWeek(@Valid @RequestBody OneControlWeek oneControlWeek) {
        oneControlWeekRepository.updateOneControlWeek(oneControlWeek);
    }

    @DeleteMapping("/delete/{subjectId}/{studentId}/{semesterId}/{teacherId}")
    public void deleteOneControlWeek(@Valid @RequestBody OneControlWeek oneControlWeek) {
        oneControlWeekRepository.deleteOneControlWeek(oneControlWeek);
    }

    @GetMapping("/field")
    public List<String> getField() {
        return oneControlWeekRepository.getField();
    }
}