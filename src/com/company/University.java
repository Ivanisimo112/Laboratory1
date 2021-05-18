package com.company;

import java.io.IOException;

public class University {
    Faculty[] faculties = new Faculty[0];
    Department[] departments = new Department[0];

    public void addDepartment(Department department) {
        Department[] departments = new Department[this.departments.length + 1];
        for (int i = 0; i < this.departments.length; i++) {
            departments[i] = this.departments[i];
        }
        departments[departments.length - 1] = department;
    }

    public void removeDepartment(Department department) {
        Department[] departments = new Department[this.departments.length - 1];
        for (int i = 0; i < this.departments.length; i++) {
            if (!this.departments[i].equals(department)) {
                departments[i] = this.departments[i];
            }
        }
        this.departments = departments;
    }

    public void addFaculty(Faculty faculty) {
        Faculty[] faculties = new Faculty[this.faculties.length + 1];
        for (int i = 0; i < this.faculties.length; i++) {
            faculties[i] = this.faculties[i];
        }
        faculties[faculties.length - 1] = faculty;
    }

    public void removeFaculty(Faculty faculty) {
        Faculty[] faculties = new Faculty[this.faculties.length - 1];
        for (int i = 0; i < this.faculties.length; i++) {
            if (!this.faculties[i].equals(faculty)) {
                faculties[i] = this.faculties[i];
            }
        }
        this.faculties = faculties;
    }

    public void changeDepartment() throws IOException {
        int number = -1;
        System.out.println("Введіть назву кафедри ,яку бажаете змінити:");
        String name = inputString();
        for (int i = 0; i < departments.length; i++) {
            if (departments[i].getName().equals(name)) {
                number = i;
                break;
            }
        }
        if (number == -1) {
            System.out.println("Цiєї кафедри немає в списку університету!");
            return;
        }
        System.out.print("Введіть нову назву: ");
        departments[number].setName(inputString());
        System.out.println("Назва змінена");
    }

    public void changeFaculty() throws IOException {
        int number = -1;
        System.out.println("Введіть назву факультету ,яку бажаете змінити:");
        String name = inputString();
        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i].getName().equals(name)) {
                number = i;
                break;
            }
        }
        if (number == -1) {
            System.out.println("Цього факультету немає в списку університету!");
            return;
        }
        System.out.print("Введіть нову назву: ");
        faculties[number].setName(inputString());
        System.out.println("Назва змінена");
    }

    private String inputString() throws IOException {
        String temp = DataInput.getString();
        for (int i = 0; i < temp.length(); i++) {
            if (!((temp.charAt(i) >= 65 && temp.charAt(i) <= 90) || (temp.charAt(i) >= 97 && temp.charAt(i) <= 122)) || temp.charAt(0) < 65 || temp.charAt(0) > 90) {
                System.out.print("Дозволено використовувати тільки літери англійського алфавіту(перша літера повинна бути великою): ");
                temp = DataInput.getString();
                i = 0;
            }
        }
        return temp;
    }
}
