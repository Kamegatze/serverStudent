package com.kamegatze.serverStudent.models;

import javax.validation.constraints.*;
import java.util.Arrays;
import java.util.List;

public class Teacher {
    @Min(1)
    private int id;
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 30)
    private String patronymic;
    @NotNull
    @NotEmpty
    @Email
    private String email;


    private List<String> field;

    public Teacher(int id, String lastName, String firstName, String patronymic, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.field = Arrays.asList("id", "Фамилия", "Имя", "Отчество", "эл. почта");
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
}
