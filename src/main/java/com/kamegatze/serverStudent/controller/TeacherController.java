package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.Teacher;
import com.kamegatze.serverStudent.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/field")
    public List<String> getField() {
        return teacherRepository.getField();
    }

    @GetMapping()
    public List<Teacher> getTeachers() {
        return teacherRepository.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable("id") int id) {
        return teacherRepository.getTeacher(id);
    }

    @PostMapping("/add")
    public void addTeacher(@Valid @RequestBody Teacher teacher) {
        teacherRepository.createTeacher(teacher);
    }

    @PatchMapping("/update")
    public void updateTeacher(@Valid @RequestBody Teacher teacher) {
        teacherRepository.updateTeacher(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTeacher(@PathVariable("id") int id) {
        teacherRepository.deleteTeacher(id);
    }
}
