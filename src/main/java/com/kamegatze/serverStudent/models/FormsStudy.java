package com.kamegatze.serverStudent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FormsStudy {
    @Min(1)
    private int id;
    @NotNull
    @NotEmpty
    private String title;

    public FormsStudy(int id, String title) {
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
