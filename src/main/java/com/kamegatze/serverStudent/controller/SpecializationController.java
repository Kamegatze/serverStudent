package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Specialization;
import com.kamegatze.serverStudent.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/specialization")
@CrossOrigin
public class SpecializationController {
    private final SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationController(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    @GetMapping()
    public List<Specialization> getSpecializations() {
        return specializationRepository.getSpecializations();
    }

    @GetMapping("/field")
    public List<String> getField() {
        return specializationRepository.getField();
    }

    @GetMapping("/{id}")
    public Specialization getSpecialization(@PathVariable("id") int id) {
        return specializationRepository.getSpecialization(id);
    }

    @PostMapping("/add")
    public void addSpecialization(@Valid @RequestBody Specialization specialization) {
        specializationRepository.createSpecialization(specialization);
    }

    @PatchMapping("/update")
    public void updateSpecialization(@Valid @RequestBody Specialization specialization) {
        specializationRepository.updateSpecialization(specialization);
    }

    @DeleteMapping("/delete")
    public void deleteSpecialization(@Valid @RequestBody Specialization specialization) {
        specializationRepository.deleteSpecialization(specialization.getId());
    }
}
