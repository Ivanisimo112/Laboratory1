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
        students[students.length - 1] = student;
        this.students = students;
    }

    public void addTeacher(Teacher teacher) {
        Teacher[] teachers = new Teacher[this.teachers.length + 1];
        for (int i = 0; i < this.teachers.length; i++) {
            teachers[i] = this.teachers[i];
        }
        teachers[teachers.length - 1] = teacher;
        this.teachers = teachers;
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
        if (number == -1) {
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
        if (number == -1) {
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

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
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

    //7

    public void sOutSortStudentsCourseOnThisDepart() {
        Student[] students1 = new Student[0];
        for (int i = 0; i < students.length; i++) {
            students1 = Utilities.addStudent(students1, students[i]);
        }

        sortCourse(students1);
        for (int i = 0; i < students1.length; i++) {
            System.out.println(students1[i].toString());
        }
    }

    private Student[] sortCourse(Student[] students) {
        if (students.length < 2) {
            return students;
        }

        Student[] ints1 = new Student[students.length / 2];
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = students[i];
        }
        Student[] ints2 = new Student[students.length - students.length / 2];
        int a = 0;
        for (int i = students.length / 2; i < students.length; i++) {
            ints2[a] = students[i];
            a++;
        }
        ints1 = sortCourse(ints1);
        ints2 = sortCourse(ints2);

        return mergerCourse(ints1, ints2);
    }

    private Student[] mergerCourse(Student[] students1, Student[] students2) {
        Student[] students = new Student[students1.length + students2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < students.length; i++) {
            if (i1 < students1.length && i2 < students2.length && students1[i1].getCourse() <= students2[i2].getCourse()) {
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

    //8.1
    public void sOutSortStudentsSurname() {
        Student[] students1 = new Student[0];
        for (int i = 0; i < students.length; i++) {
            students1 = Utilities.addStudent(students1, students[i]);
        }

        sortStudentsName(students1);
        for (int i = 0; i < students1.length; i++) {
            System.out.println(students1[i].toString());
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

    //8.2
    public void sOutSortTeachersSurname() {
        Teacher[] teachers1 = new Teacher[0];
        for (int i = 0; i < teachers.length; i++) {
            teachers1 = Utilities.addTeacher(teachers1, teachers[i]);
        }


        sortTeachersName(teachers1);
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

    public void sOutAllStudentsOnThisCourse(){
        System.out.print("Вкажіть курс студентів якого потрібно вивести: ");
        int course = DataInput.getInt();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCourse()==course){
                System.out.println(students[i].toString());
            }
        }
    }

    public void sOutAllStudentsSortSurname(){
        System.out.print("Вкажіть курс студентів якого потрібно вивести відсортованими на прізвище: ");
        Student[] searchResult = new Student[0];
        int course = DataInput.getInt();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCourse()==course){
                searchResult = Utilities.addStudent(searchResult,students[i]);
            }
        }
        searchResult = sortStudentsName(searchResult);
        for (int i = 0; i < searchResult.length; i++) {
            System.out.println(searchResult[i].toString());
        }
    }
}
