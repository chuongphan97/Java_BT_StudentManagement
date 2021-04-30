package com.StudentManagement.presentation;

import com.StudentManagement.model.Student;
import com.StudentManagement.service.StudentService;

import java.io.IOException;
import java.util.*;

public class Main {
    public static StudentService studentService;
    static {
        studentService = new StudentService();
    }
    public static void main(String[] args) {
        try {
            studentService.loadFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM!!!");

        int choose = 1;
        while (choose != 0){
            createMenu();

            do {
                System.out.println("Enter number: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid id! Please enter your id: ");
                    sc.next();
                }
                choose = sc.nextInt();
            } while (choose < 0 || choose > 7);
            switch (choose){
                case 1: printList();

                    break;
                case 2:
                    try {
                        add();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        editStudent();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        remove();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        inputScore();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        editScore();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        printListSorted();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

    }

    public static void createMenu(){
        System.out.println("--------------------MENU--------------------");
        System.out.println("\t 1. Print list student.");
        System.out.println("\t 2. Add student.");
        System.out.println("\t 3. Edit student.");
        System.out.println("\t 4. Remove student.");
        System.out.println("\t 5. Input score student.");
        System.out.println("\t 6. Edit score student.");
        System.out.println("\t 7. Classify student.");
        System.out.println("\t 0. Exit system.");
        System.out.println("-------------------------------------------------");
    }

    public static void printList(){
        studentService.printList();
    }
    public static void add() throws IOException {
        System.out.println("Enter name: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Enter gender: ");
        String gender = new Scanner(System.in).nextLine();
        studentService.add(new Student(0,name,gender));
    }

    public static void editStudent() throws IOException {

        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.println("Please enter your id: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid id! Please enter your id: ");
                sc.next();
            }
            id = sc.nextInt();
        } while (id < 0);

        System.out.println("Enter new name: ");
        String newName = new Scanner(System.in).nextLine();
        System.out.println("Enter new gender: ");
        String newGender = new Scanner(System.in).nextLine();
        studentService.editStudent(id,newName, newGender);
    }

    public static void remove() throws IOException {
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.println("Please enter your id: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            id = sc.nextInt();
        } while (id < 0);
        studentService.remove(id);
    }

    public static void inputScore() throws IOException {
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.println("Please enter your id: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            id = sc.nextInt();
        } while (id < 0);

        Scanner sc1 = new Scanner(System.in);
        double firstScoreX1;
        do {
            System.out.println("Please enter your first score x1: ");
            while (!sc1.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc1.next();
            }
            firstScoreX1 = sc1.nextDouble();
        } while (firstScoreX1 < 0 || firstScoreX1 > 10);


        Scanner sc2 = new Scanner(System.in);
        double secondScoreX1;
        do {
            System.out.println("Enter your second score x1: ");
            while (!sc2.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc2.next();
            }
            secondScoreX1 = sc2.nextDouble();
        } while (secondScoreX1 < 0 || secondScoreX1 > 10);

        Scanner sc3 = new Scanner(System.in);
        double scoreX2;
        do {
            System.out.println("Enter your score x2: ");
            while (!sc3.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc3.next();
            }
            scoreX2 = sc3.nextDouble();
        } while (scoreX2 < 0 || scoreX2 > 10);

        Scanner sc4 = new Scanner(System.in);
        double scoreX3;
        do {
            System.out.println("Enter your score x3: ");
            while (!sc4.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc4.next();
            }
            scoreX3 = sc4.nextDouble();
        } while (scoreX3 < 0 || scoreX3 > 10);

        studentService.putScore(id,firstScoreX1,secondScoreX1,scoreX2,scoreX3);
    }

    public static void editScore() throws IOException {
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.println("Please enter your id: ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid number! Please enter your number: ");
                sc.next();
            }
            id = sc.nextInt();
        } while (id < 0);

        Scanner sc1 = new Scanner(System.in);
        double firstScoreX1;
        do {
            System.out.println("Please enter your first score x1: ");
            while (!sc1.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc1.next();
            }
            firstScoreX1 = sc1.nextDouble();
        } while (firstScoreX1 < 0 || firstScoreX1 > 10);


        Scanner sc2 = new Scanner(System.in);
        double secondScoreX1;
        do {
            System.out.println("Enter your second score x1: ");
            while (!sc2.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc2.next();
            }
            secondScoreX1 = sc2.nextDouble();
        } while (secondScoreX1 < 0 || secondScoreX1 > 10);

        Scanner sc3 = new Scanner(System.in);
        double scoreX2;
        do {
            System.out.println("Enter your score x2: ");
            while (!sc3.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc3.next();
            }
            scoreX2 = sc3.nextDouble();
        } while (scoreX2 < 0 || scoreX2 > 10);

        Scanner sc4 = new Scanner(System.in);
        double scoreX3;
        do {
            System.out.println("Enter your score x3: ");
            while (!sc4.hasNextDouble()) {
                System.out.println("Invalid score! Please enter your score: ");
                sc4.next();
            }
            scoreX3 = sc4.nextDouble();
        } while (scoreX3 < 0 || scoreX3 > 10);

        studentService.editScore(id,firstScoreX1,secondScoreX1,scoreX2,scoreX3);
    }

    public static void printListSorted() throws IOException {
        studentService.printListSorted();
    }

}
