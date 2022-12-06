package com.kamegatze.serverStudent.models;

import javax.validation.constraints.*;

public class Semesters {
    @Min(1)
    @Max(8)
    private int id;
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 30)
    private String name;

    public Semesters(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
