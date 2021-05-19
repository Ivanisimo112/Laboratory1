package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.company.Utilities.inputString;

public class Faculty {
    private String name;
    private Department[] departments = new Department[0];

    public Department[] getDepartments() {
        return departments;
    }

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

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

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

    //6.1
    public void sOutSortStudentsSurname() {
        Student[] searchResult = new Student[0];
        for (int j = 0; j < departments.length; j++) {
            for (int k = 0; k < departments[j].getStudents().length; k++) {
                searchResult = Utilities.addStudent(searchResult, departments[j].getStudents()[k]);
            }
        }

        searchResult = sortStudentsName(searchResult);
        for (int i = 0; i < searchResult.length; i++) {
            System.out.println(searchResult[i].toString());
        }
    }

    private Student[] sortStudentsName(Student[] students) {
        if (students.length < 2) {
            return students;
        }
        Student[] studentsCopy = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            studentsCopy[i] = students[i];
        }
        Student[] students1 = new Student[studentsCopy.length / 2];
        for (int i = 0; i < students1.length; i++) {
            students1[i] = studentsCopy[i];
        }
        Student[] students2 = new Student[studentsCopy.length - studentsCopy.length / 2];
        int a = 0;
        for (int i = studentsCopy.length / 2; i < studentsCopy.length; i++) {
            students2[a] = studentsCopy[i];
            a++;
        }
        students1 = sortStudentsName(students1);
        students2 = sortStudentsName(students2);

        return mergerStudentsName(students1, students2);
    }

    private Student[] mergerStudentsName(Student[] students1, Student[] students2) {
        Student[] students = new Student[students1.length + students2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < students.length; i++) {
            if (i1 < students1.length && i2 < students2.length && students1[i1].getSurname().charAt(0) <= students2[i2].getSurname().charAt(0)) {
                students[i] = students1[i1];
                i1++;
            } else if (i2 == students2.length) {
                students[i] = students1[i1];
                i1++;
            } else if (i1 == students1.length) {
                students[i] = students2[i2];
                i2++;
            } else {
                students[i] = students2[i2];
                i2++;
            }
        }

        return students;
    }


    //6.2
    public void sOutSortTeachersSurname() {
        Teacher[] teachers1 = new Teacher[0];
        for (int j = 0; j < departments.length; j++) {
            for (int k = 0; k < departments[j].getTeachers().length; k++) {
                teachers1 = Utilities.addTeacher(teachers1, departments[j].getTeachers()[k]);
            }
        }

        teachers1 = sortTeachersName(teachers1);
        for (int i = 0; i < teachers1.length; i++) {
            System.out.println(teachers1[i].toString());
        }
    }

    private Teacher[] sortTeachersName(Teacher[] teachers) {
        if (teachers.length < 2) {
            return teachers;
        }
        Teacher[] teachersCopy = new Teacher[teachers.length];
        for (int i = 0; i < teachers.length; i++) {
            teachersCopy[i] = teachers[i];
        }
        Teacher[] teachers1 = new Teacher[teachersCopy.length / 2];
        for (int i = 0; i < teachers1.length; i++) {
            teachers1[i] = teachersCopy[i];
        }
        Teacher[] teachers2 = new Teacher[teachersCopy.length - teachersCopy.length / 2];
        int a = 0;
        for (int i = teachersCopy.length / 2; i < teachersCopy.length; i++) {
            teachers2[a] = teachersCopy[i];
            a++;
        }
        teachers1 = sortTeachersName(teachers1);
        teachers2 = sortTeachersName(teachers2);

        return mergerTeachersName(teachers1, teachers2);
    }

    private Teacher[] mergerTeachersName(Teacher[] teachers1, Teacher[] teachers2) {
        Teacher[] teachers = new Teacher[teachers1.length + teachers2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < teachers.length; i++) {
            if (i1 < teachers1.length && i2 < teachers2.length && teachers1[i1].getSurname().charAt(0) <= teachers2[i2].getSurname().charAt(0)) {
                teachers[i] = teachers1[i1];
                i1++;
            } else if (i2 == teachers2.length) {
                teachers[i] = teachers1[i1];
                i1++;
            } else if (i1 == teachers1.length) {
                teachers[i] = teachers2[i2];
                i2++;
            } else {
                teachers[i] = teachers2[i2];
                i2++;
            }
        }

        return teachers;
    }
}
