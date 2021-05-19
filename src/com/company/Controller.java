package com.company;

import java.io.IOException;

public class Controller {
    public static void main(String[] args) throws IOException {
        University university = new University();
        Student student = new Student("Ivan","Banan","Volodimirovich",1,4);
        Teacher teacher = new Teacher("A","B","V",3,4);
        Department department = new Department("DIBILOV");
        Faculty faculty = new Faculty("INFORMATOIN");

        university.addFaculty(faculty);
        faculty.addDepartment(department);
        department.addStudent(student);
        department.addTeacher(teacher);
        department.changeStudent(student);
    }
}
