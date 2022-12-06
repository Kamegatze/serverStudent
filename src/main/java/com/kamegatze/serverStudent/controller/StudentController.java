package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Student;
import com.kamegatze.serverStudent.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {
    private StudentsRepository studentsRepository;

    @Autowired
    public StudentController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentsRepository.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student student = studentsRepository.getStudent(id);;
        return student;
    }

    @GetMapping("/field")
    public List<String> getField() {
        return studentsRepository.getField();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@Valid @RequestBody Student student) {
        studentsRepository.addStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentsRepository.deleteStudent(id);
    }

    @PatchMapping("/update/{id}")
    public void updateStudent(@Valid @RequestBody Student student, @PathVariable("id") int id) {
        studentsRepository.updateStudent(student, id);
    }
}
