package com.company;

import java.io.IOException;

public class Department {
    private String name;
    private Student[] students = new Student[0];
    private Teacher[] teachers = new Teacher[0];

    public void addStudent(Student student) {
        Student[] students = new Student[this.students.length + 1];
        for (int i = 0; i < this.students.length; i++) {
            students[i] = this.students[i];
        }
        this.students[students.length - 1] = student;
    }

    public void addTeacher(Teacher teacher) {
        Teacher[] teachers = new Teacher[this.teachers.length + 1];
        for (int i = 0; i < this.teachers.length; i++) {
            teachers[i] = this.teachers[i];
        }
        this.teachers[teachers.length - 1] = teacher;
    }

    public void removeStudent(Student student) {
        Student[] students = new Student[this.students.length - 1];
        for (int i = 0; i < this.students.length; i++) {
            if (!this.students[i].equals(student)) {
                students[i] = this.students[i];
            }
        }
        this.students = students;
    }

    public void removeTeacher(Teacher teacher) {
        Teacher[] teachers = new Teacher[this.teachers.length - 1];
        for (int i = 0; i < this.teachers.length; i++) {
            if (!this.teachers[i].equals(teacher)) {
                teachers[i] = this.teachers[i];
            }
        }
        this.teachers = teachers;
    }

    public void changeStudent(Student student) throws IOException {
        int number = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(student)) {
                number = i;
                break;
            }
        }
        if (number==-1){
            System.out.println("Цього студента немає в списку університету!");
            return;
        }
        int contin = 1;
        while (contin == 1) {
            int i = whatChange();
            if (i == 1) {
                System.out.print("Введіть ім'я: ");
                students[number].setName(Utilities.inputString());
            } else if (i == 2) {
                System.out.print("Введіть прізвище: ");
                students[number].setSurname(Utilities.inputString());
            } else if (i == 3) {
                System.out.print("Введіть по батькові: ");
                students[number].setPatronymic(Utilities.inputString());
            } else if (i == 4) {
                System.out.print("Введіть курс: ");
                students[number].setCourse(Utilities.inputInt());
            } else if (i == 5) {
                System.out.print("Введіть групу: ");
                students[number].setGroup(Utilities.inputInt());
            }
            System.out.println("Інформація про студента змінена, бажаєте змінити щось ще?(1-так,інше число-ні): ");
            contin = DataInput.getInt();
        }

    }

    public void changeTeacher(Teacher teacher) throws IOException {
        int number = -1;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i].equals(teacher)) {
                number = i;
                break;
            }
        }
        if (number==-1){
            System.out.println("Цього викладача немає в списку університету!");
            return;
        }
        int contin = 1;
        while (contin == 1) {
            int i = whatChange();
            if (i == 1) {
                System.out.print("Введіть ім'я: ");
                teachers[number].setName(Utilities.inputString());
            } else if (i == 2) {
                System.out.print("Введіть прізвище: ");
                teachers[number].setSurname(Utilities.inputString());
            } else if (i == 3) {
                System.out.print("Введіть по батькові: ");
                teachers[number].setPatronymic(Utilities.inputString());
            } else if (i == 4) {
                System.out.print("Введіть курс: ");
                teachers[number].setCourse(Utilities.inputInt());
            } else if (i == 5) {
                System.out.print("Введіть групу: ");
                teachers[number].setGroup(Utilities.inputInt());
            }
            System.out.println("Інформація про викладача змінена, бажаєте змінити щось ще?(1-так,інше число-ні): ");
            contin = DataInput.getInt();
        }

    }

    private int whatChange() {
        System.out.println("1) Змінити ім'я\n" +
                "2) Змінити прізвище\n" +
                "3) Змінити батькові\n" +
                "4) Змінити курс\n" +
                "5) Змінити групу");
        System.out.print("Виберіть один з 5 варіантів (Введіть від 1 до 5): ");
        int temp = DataInput.getInt();
        while (temp > 5 || temp < 1) {
            System.out.print("Введіть від 1 до 5!!!!: ");
            temp = DataInput.getInt();
        }
        return temp;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
