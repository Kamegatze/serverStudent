package com.kamegatze.serverStudent.models;

import javax.validation.constraints.*;
import java.util.*;

public class Student {
    @Min(0)
    private int id;
    @NotEmpty
    @Size(min=2, max=30)
    private String lastName;
    @NotEmpty
    @Size(min=2, max=30)
    private String firstName;
    @NotEmpty
    @Size(min=2, max=30)
    private String patronymic;
    @Min(1)
    @Max(2)
    private int formStudyId;
    @Min(1)
    private int groupId;
    @NotEmpty
    @NotNull
    @Email
    private String email;

    private List<String> field;

    public Student(int id, String lastName, String firstName, String patronymic, int formStudyId, int groupId, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.formStudyId = formStudyId;
        this.groupId = groupId;
        this.email = email;
        this.field = Arrays.asList("id", "Фамилия", "Имя", "Отчество", "форма обучения", "группа", "эл. почта");
    }

    public List<String> getField() {
        return field;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getFormStudyId() {
        return formStudyId;
    }

    public int getGroupId() {
        return groupId;
    }
}
