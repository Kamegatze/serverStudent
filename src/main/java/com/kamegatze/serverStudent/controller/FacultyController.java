package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Faculty;
import com.kamegatze.serverStudent.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/faculty")
@CrossOrigin
public class FacultyController {
    private FacultyRepository facultyRepository;

    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @GetMapping()
    public List<Faculty> getFaculty() {
        return facultyRepository.getFaculty();
    }

    @PostMapping("/add")
    public void addFaculty(@Valid @RequestBody Faculty faculty) {
        facultyRepository.addFaculty(faculty);
    }

    @PatchMapping("/update")
    public void setFaculty(@Valid @RequestBody Faculty faculty) {
        facultyRepository.updateFaculty(faculty);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFaculty(@PathVariable("id") int id){
        facultyRepository.deleteFaculty(id);
    }
}
