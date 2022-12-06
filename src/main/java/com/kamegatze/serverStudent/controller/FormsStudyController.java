package com.kamegatze.serverStudent.controller;

import com.kamegatze.serverStudent.models.FormsStudy;
import com.kamegatze.serverStudent.repository.FormsStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/formStudy")
@CrossOrigin
public class FormsStudyController {
    private FormsStudyRepository formsStudyRepository;

    @Autowired
    public FormsStudyController(FormsStudyRepository formsStudyRepository) {
        this.formsStudyRepository = formsStudyRepository;
    }
    @GetMapping()
    public List<FormsStudy> getFormsStudy() {
        return formsStudyRepository.getFormsStudy();
    }
}
