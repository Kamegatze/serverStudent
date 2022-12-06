package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.ThreeControlWeek;
import com.kamegatze.serverStudent.repository.ThreeControlWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/threeControlWeek")
@CrossOrigin
public class ThreeControlWeekController {
    private final ThreeControlWeekRepository threeControlWeekRepository;

    @Autowired
    public ThreeControlWeekController(ThreeControlWeekRepository threeControlWeekRepository) {
        this.threeControlWeekRepository = threeControlWeekRepository;
    }

    @GetMapping()
    public List<ThreeControlWeek> getThreeControlWeekRecords() {
        return threeControlWeekRepository.getThreeControlWeek();
    }

    @GetMapping("/search")
    public ThreeControlWeek getThreeControlWeekRecord(@RequestBody @Valid ThreeControlWeek threeControlWeek) {
        return threeControlWeekRepository.searchThreeControlWeek(threeControlWeek);
    }

    @PostMapping("/add")
    public void addThreeControlWeek(@Valid @RequestBody ThreeControlWeek threeControlWeek) {
        threeControlWeekRepository.addThreeControlWeek(threeControlWeek);
    }

    @PatchMapping("/update")
    public void updateThreeControlWeek(@Valid @RequestBody ThreeControlWeek threeControlWeek) {
        threeControlWeekRepository.updateThreeControlWeek(threeControlWeek);
    }

    @DeleteMapping("/delete")
    public void deleteThreeControlWeek(@Valid @RequestBody ThreeControlWeek threeControlWeek) {
        threeControlWeekRepository.deleteThreeControlWeek(threeControlWeek);
    }

    @GetMapping("/field")
    public List<String> getField() {
        return threeControlWeekRepository.getField();
    }
}
