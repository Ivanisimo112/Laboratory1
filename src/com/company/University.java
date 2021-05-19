package com.company;

import java.io.IOException;

public class University {
    Faculty[] faculties = new Faculty[0];

    public void addFaculty(Faculty faculty) {
        Faculty[] faculties = new Faculty[this.faculties.length + 1];
        for (int i = 0; i < this.faculties.length; i++) {
            faculties[i] = this.faculties[i];
        }
        faculties[faculties.length - 1] = faculty;
        this.faculties = faculties;
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

    public void changeFaculty() throws IOException {
        int number = -1;
        System.out.print("Введіть назву факультету ,яку бажаете змінити:");
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


    //4
    public Student searchStudent() throws IOException {
        int wS = whatSearch();
        String searName = null;
        String searSurname = null;
        int searCourse = -1;
        int searGroup = -1;

        if (wS == 1) {
            System.out.print("Введіть ім'я: ");
            searName = Utilities.inputString();
        } else if (wS == 2) {
            System.out.print("Введіть прізвище: ");
            searSurname = Utilities.inputString();
        } else if (wS == 3) {
            System.out.print("Введіть курс: ");
            searCourse = Utilities.inputInt();
        } else if (wS == 4) {
            System.out.print("Введіть групу: ");
            searGroup = Utilities.inputInt();
        }

        if (searName != null) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getStudents().length; k++) {
                        if (faculties[i].getDepartments()[j].getStudents()[k].getName().equals(searName)) {
                            return faculties[i].getDepartments()[j].getStudents()[k];
                        }
                    }
                }
            }
        } else if (searSurname != null) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getStudents().length; k++) {
                        if (faculties[i].getDepartments()[j].getStudents()[k].getSurname().equals(searSurname)) {
                            return faculties[i].getDepartments()[j].getStudents()[k];
                        }
                    }
                }
            }
        } else if (searCourse != -1) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getStudents().length; k++) {
                        if (faculties[i].getDepartments()[j].getStudents()[k].getCourse() == searCourse) {
                            return faculties[i].getDepartments()[j].getStudents()[k];
                        }
                    }
                }
            }
        } else if (searGroup != -1) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getStudents().length; k++) {
                        if (faculties[i].getDepartments()[j].getStudents()[k].getGroup() == searGroup) {
                            return faculties[i].getDepartments()[j].getStudents()[k];
                        }
                    }
                }
            }
        }
        return null;
    }

    public Teacher searchTeacher() throws IOException {
        int wS = whatSearch();
        String searName = null;
        String searSurname = null;
        int searCourse = -1;
        int searGroup = -1;

        if (wS == 1) {
            System.out.print("Введіть ім'я: ");
            searName = Utilities.inputString();
        } else if (wS == 2) {
            System.out.print("Введіть прізвище: ");
            searSurname = Utilities.inputString();
        } else if (wS == 3) {
            System.out.print("Введіть курс: ");
            searCourse = Utilities.inputInt();
        } else if (wS == 4) {
            System.out.print("Введіть групу: ");
            searGroup = Utilities.inputInt();
        }

        if (searName != null) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length; k++) {
                        if (faculties[i].getDepartments()[j].getTeachers()[k].getName().equals(searName)) {
                            return faculties[i].getDepartments()[j].getTeachers()[k];
                        }
                    }
                }
            }
        } else if (searSurname != null) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length; k++) {
                        if (faculties[i].getDepartments()[j].getTeachers()[k].getSurname().equals(searSurname)) {
                            return faculties[i].getDepartments()[j].getTeachers()[k];
                        }
                    }
                }
            }
        } else if (searCourse != -1) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length; k++) {
                        if (faculties[i].getDepartments()[j].getTeachers()[k].getCourse() == searCourse) {
                            return faculties[i].getDepartments()[j].getTeachers()[k];
                        }
                    }
                }
            }
        } else if (searGroup != -1) {
            for (int i = 0; i < faculties.length; i++) {
                for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                    for (int k = 0; k < faculties[i].getDepartments()[j].getTeachers().length; k++) {
                        if (faculties[i].getDepartments()[j].getTeachers()[k].getGroup() == searGroup) {
                            return faculties[i].getDepartments()[j].getTeachers()[k];
                        }
                    }
                }
            }
        }
        return null;
    }


    //5
    public void sOutSortStudentsCourse() {
        Student[] searchResult = new Student[0];
        for (int i = 0; i < faculties.length; i++) {
            for (int j = 0; j < faculties[i].getDepartments().length; j++) {
                for (int k = 0; k < faculties[i].getDepartments()[j].getStudents().length; k++) {
                    searchResult = Utilities.addStudent(searchResult,faculties[i].getDepartments()[j].getStudents()[i]);
                }
            }
        }
        sortCourse(searchResult);
        for (int i = 0; i < searchResult.length; i++) {
            System.out.println(searchResult[i].toString());
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

    private Student[] mergerCourse(Student[] students1, Student[] students2){
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

    private int whatSearch() {
        System.out.println("1) Знайти по імені\n" +
                "2) Знайти на прізвище\n" +
                "3) Знайти за курсом\n" +
                "4) Знайти по групі");
        System.out.print("Виберіть один з 4 варіантів (Введіть від 1 до 4): ");
        int temp = DataInput.getInt();
        while (temp > 4 || temp < 1) {
            System.out.print("Введіть від 1 до 4!!!!: ");
            temp = DataInput.getInt();
        }
        return temp;
    }


}
