package com.kamegatze.serverStudent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Faculty {
    @Min(0)
    private int id;
    @Size(min = 5, max = 100)
    @NotEmpty
    @NotNull
    private String title;

    public Faculty(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
