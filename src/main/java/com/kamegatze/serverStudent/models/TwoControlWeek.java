package com.kamegatze.serverStudent.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.*;
public class TwoControlWeek {
    @Min(1)
    private int studentId;
    @Min(1)
    private int subjectId;
    @Min(1)
    private int teacherId;
    @Min(1)
    @Max(8)
    private int semesterId;
    @Min(0)
    @Max(2)
    private double mark;

    private List<String> field;

    public TwoControlWeek(int studentId, int subjectId, int teacherId, int semesterId, double mark) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.semesterId = semesterId;
        this.mark = mark;
        this.field = Arrays.asList("id", "студент", "группа", "предмет", "преподаватель", "семестр", "успеваемость");
    }

    public List<String> getField() {
        return field;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public double getMark() {
        return mark;
    }
}
