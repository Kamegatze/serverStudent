package com.kamegatze.serverStudent.controller;


import com.kamegatze.serverStudent.models.TwoControlWeek;
import com.kamegatze.serverStudent.repository.TwoControlWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/twoControlWeek")
@CrossOrigin
public class TwoControlWeekController {
    private final TwoControlWeekRepository twoControlWeekRepository;

    @Autowired
    public TwoControlWeekController(TwoControlWeekRepository twoControlWeekRepository) {
        this.twoControlWeekRepository = twoControlWeekRepository;
    }

    @GetMapping()
    public List<TwoControlWeek> getTwoControlWeek() {
        return twoControlWeekRepository.getTwoControlWeek();
    }

    @GetMapping("/search")
    public TwoControlWeek searchTwoControlWeek(@Valid @RequestBody TwoControlWeek twoControlWeek) {
        return twoControlWeekRepository.searchTwoControlWeek(twoControlWeek);
    }

    @PostMapping("/add")
    public void addTwoControlWeek(@Valid @RequestBody TwoControlWeek twoControlWeek) {
        twoControlWeekRepository.addTwoControlWeek(twoControlWeek);
    }

    @PatchMapping("/update")
    public void updateTwoControlWeek(@Valid @RequestBody TwoControlWeek twoControlWeek) {
        twoControlWeekRepository.updateTwoControlWeek(twoControlWeek);
    }

    @DeleteMapping("/delete")
    public void deleteTwoControlWeek(@Valid @RequestBody TwoControlWeek twoControlWeek) {
        twoControlWeekRepository.deleteTwoControlWeek(twoControlWeek);
    }

    @GetMapping("/field")
    public List<String> getField() {
        return twoControlWeekRepository.getField();
    }
}
