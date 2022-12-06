package com.kamegatze.serverStudent.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;
public class GroupFaculty {
    @Min(1)
    private int id;
    @NotEmpty
    @NotNull
    @Size(min = 2)
    private String title;
    @Min(1)
    private int specializationId;

    private List<String> field;

    public GroupFaculty(int id, String title, int specializationId) {
        this.id = id;
        this.title = title;
        this.specializationId = specializationId;
        this.field = Arrays.asList("id", "группа", "специализация");
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

    public int getSpecializationId() {
        return specializationId;
    }
}
