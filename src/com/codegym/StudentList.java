package com.codegym;

import java.util.Scanner;

public class StudentList {
    static int size;
    static Scanner sc = new Scanner(System.in);
    static Student[] studentList;

    //display list of students
    static void displayStudentList(Student[] studentList) {
        System.out.println("List of all students: ");
        for (int i = 0; i < studentList.length; i++) {
            studentList[i].display();
        }
        System.out.println();
    }

    //init student with id = i
    static Student initStudent(int i) {
        sc.nextLine();
        Student student = new Student();
        student.setId(i + 1);

        System.out.println("Enter the name of student " + (i + 1) + ": ");
        student.setName(sc.nextLine());

        System.out.println("Enter the date of birth of student " + (i + 1) + ": ");
        student.setBirthDate(sc.nextLine());

        System.out.println("Enter the score of student " + (i + 1) + ": ");
        student.setScore(sc.nextInt());
        sc.nextLine();
        return student;
    }

    //remove student with id = index_del
    static Student[] removeStudent(int index_del) {
        Student[] newList = new Student[studentList.length - 1];
        for (int i = 0; i < index_del; i++) {
            newList[i] = studentList[i];
        }
        for (int i = index_del + 1; i < studentList.length; i++) {
            newList[i - 1] = studentList[i];
            newList[i - 1].setId(i);
        }
        return newList;
    }

    //add a student
    static Student[] addStudent() {
        Student[] newList = new Student[studentList.length + 1];
        for (int i = 0; i < studentList.length; i++) {
            newList[i] = studentList[i];
        }
        newList[studentList.length] = initStudent(studentList.length);
        return newList;
    }

    //edit a student info with id = index_edit
    static Student[] editStudent(int index_edit) {
        studentList[index_edit] = initStudent(index_edit);
        return studentList;
    }

    static void FindMaxScore(){
        int maxScore = studentList[0].getScore();
        int maxId = 0;
        for (int i = 0; i < studentList.length; i++){
            if (studentList[i].getScore() > maxScore){
                maxScore = studentList[i].getScore();
            }
        }

        for (int i = 0; i < studentList.length; i++){
            if (studentList[i].getScore() == maxScore){
                studentList[i].display();
            }
        }
    }


    static Student[] SortDescending(){
        Student[] newArray = new Student[studentList.length];
        for (int i = 0; i < studentList.length; i++){
            newArray[i] = studentList[i];
        }

        for (int i = 0; i < newArray.length; i++) {
            for (int j = i + 1; j < newArray.length; j++) {
                Student temp;
                if (newArray[i].getScore() < newArray[j].getScore()) {
                    temp = newArray[i];
                    newArray[i] = newArray[j];
                    newArray[j] = temp;
                }
            }
        }
        return newArray;
    }


    //print the default menu
    static void printMenu() {
        System.out.println();
        System.out.println("Menu: ");
        System.out.println("1. Display all students");
        System.out.println("2. Remove a student");
        System.out.println("3. Add a student");
        System.out.println("4. Edit information of a student");
        System.out.println("5. Find the student with highest score");
        System.out.println("6. Sort from the highest score");
        System.out.println("0. Exit");
        System.out.println("Enter the code for each task: ");
    }

    public static void main(String[] args) {
        int choice = -1;
        System.out.println("Enter the number of students: ");
        size = sc.nextInt();
        sc.nextLine();

        studentList = new Student[size];
        for (int i = 0; i < size; i++) {
            studentList[i] = initStudent(i);
        }

        while (choice != 0) {
            printMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    displayStudentList(studentList);
                    break;
                }
                case 2: {
                    System.out.println("Enter the ID of student to be removed: ");
                    studentList = removeStudent(sc.nextInt() - 1);
                    displayStudentList(studentList);
                    break;
                }
                case 3: {
                    studentList = addStudent();
                    displayStudentList(studentList);
                    break;
                }
                case 4: {
                    System.out.println("Enter the ID of student to be edited: ");
                    studentList = editStudent(sc.nextInt() - 1);
                    displayStudentList(studentList);
                    break;
                }
                case 5: {
                    FindMaxScore();
                    break;
                }
                case 6: {
                    Student[] newArray = SortDescending();
                    displayStudentList(newArray);
                    break;
                }
                case 0: {
                    System.exit(0);
                }
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
