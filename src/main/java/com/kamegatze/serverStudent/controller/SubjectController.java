package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Subject;
import com.kamegatze.serverStudent.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {
    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/field")
    public List<String> getField() {
        return subjectRepository.getField();
    }

    @GetMapping()
    public List<Subject> getSubject() {
        return subjectRepository.getSubject();
    }

    @GetMapping("/{id}")
    public Subject getSubjectId(@PathVariable("id") int id){
        return subjectRepository.getSubjectId(id);
    }

    @PostMapping("/add")
    public void addSubject(@Valid @RequestBody Subject subject) {
        subjectRepository.addSubject(subject);
    }

    @PatchMapping("/update")
    public void updateSubject(@Valid @RequestBody Subject subject) {
        subjectRepository.updateSubject(subject, subject.getId());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubject(@PathVariable("id") int id) {
        subjectRepository.deleteSubject(id);
    }
}
