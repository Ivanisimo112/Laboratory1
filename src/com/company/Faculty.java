package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Faculty {
    private String name;
    private Department[] departments = new Department[0];

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Arrays.equals(departments, faculty.departments);
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
