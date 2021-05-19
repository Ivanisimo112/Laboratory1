package com.company;

import java.io.IOException;

public class Utilities {
    public static int inputInt() throws IOException {
        String temp = DataInput.getString();
        for (int i = 0; i < temp.length(); i++) {
            if ((temp.charAt(i) > 57 && temp.charAt(i) < 48)) {
                System.out.print("Дозволено використовувати тільки цифри: ");
                temp = DataInput.getString();
                i = 0;
            }
        }
        return Integer.parseInt(temp);
    }

    public static String inputString() throws IOException {
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

    public static Student[] addStudent(Student[] students, Student student){
        Student[] students1 = new Student[students.length+1];
        for (int i = 0; i < students.length; i++) {
            students1[i]=students[i];
        }
        students1[students1.length-1]=student;
        return students1;
    }

    public static Teacher[] addTeacher(Teacher[] teachers, Teacher teacher){
        Teacher[] teachers1 = new Teacher[teachers.length+1];
        for (int i = 0; i < teachers.length; i++) {
            teachers1[i]=teachers[i];
        }
        teachers1[teachers1.length-1]=teacher;
        return teachers1;
    }
}
