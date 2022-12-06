package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.GroupFaculty;
import com.kamegatze.serverStudent.repository.GroupFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/groupFaculty")
@CrossOrigin
public class GroupFacultyController {
    private final GroupFacultyRepository groupFacultyRepository;

    @Autowired
    public GroupFacultyController(GroupFacultyRepository groupFacultyRepository) {
        this.groupFacultyRepository = groupFacultyRepository;
    }

    @GetMapping()
    public List<GroupFaculty> getGroupFaculty() {
        return groupFacultyRepository.getGroupFaculty();
    }

    @GetMapping("/field")
    public List<String> getField() {
        return groupFacultyRepository.getField();
    }

    @GetMapping("/{id}")
    public GroupFaculty getGroupFacultyId(@PathVariable("id") int id) {
        return groupFacultyRepository.getGroupFacultyID(id);
    }

    @PostMapping("/add")
    public void addGroupFaculty(@Valid @RequestBody GroupFaculty groupFaculty) {
        groupFacultyRepository.createGroupFaculty(groupFaculty);
    }

    @PatchMapping("/update")
    public void updateGroupFaculty(@Valid @RequestBody GroupFaculty groupFaculty) {
        groupFacultyRepository.updateGroupFaculty(groupFaculty);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteGroupFaculty(@PathVariable ("id") int id) {
        groupFacultyRepository.deleteGroupFaculty(id);
    }
}
