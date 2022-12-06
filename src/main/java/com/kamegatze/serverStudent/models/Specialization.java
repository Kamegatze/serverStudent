package com.kamegatze.serverStudent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Specialization {
    @Min(1)
    private int id;
    @NotEmpty
    @NotNull
    @Size(min = 8)
    private String title;
    @Min(1)
    private int facultyId;

    public Specialization(int id, String title, int facultyId) {
        this.id = id;
        this.title = title;
        this.facultyId = facultyId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getFacultyId() {
        return facultyId;
    }
}