package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Faculty {
    String name;
    Department[] departments = new Department[0];
    Student[] students;
    Teacher[] teachers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Arrays.equals(departments, faculty.departments) &&
                Arrays.equals(students, faculty.students) &&
                Arrays.equals(teachers, faculty.teachers);
    }

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
