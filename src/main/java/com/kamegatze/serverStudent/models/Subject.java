package com.kamegatze.serverStudent.models;

import com.sun.istack.NotNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;
public class Subject {
    @Min(1)
    private int id;
    @Size(min = 2, max = 100)
    @NotEmpty
    @NotNull
    private String title;

    private List<String> field;
    public Subject(int id, String title) {
        this.id = id;
        this.title = title;
        this.field = new ArrayList<>();
        this.field.add("id");
        this.field.add("Наименование");
    }

    public List<String> getField() {
        return field;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
