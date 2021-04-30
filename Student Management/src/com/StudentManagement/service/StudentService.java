package com.StudentManagement.service;

import com.StudentManagement.dal.StudentDB;
import com.StudentManagement.model.Student;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.ArrayList;

public class StudentService {
    public StudentDB studentDB = new StudentDB();


    public void add(Student student) throws IOException {
        studentDB.add(student);
        studentDB.writeFile();
    }

    public void remove(int id) throws IOException {
        if (studentDB.remove(id)) {
            System.out.println("Completed remove!");
        } else {
            System.out.println("Invalid id!");
        }
    }

    public void printList(){
        studentDB.printList();
    }

    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) throws IOException {
        if (studentDB.getId(id) != null) {
            studentDB.putScore(id, newFirstScoreX1, newSecondScoreX1, newScoreX2, newScoreX3);
            System.out.println("Put score successfully.");
        } else {
            System.out.println("Invalid Id.");
        }

    }

    public void editScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) throws IOException {
        if (studentDB.getId(id) != null){
            studentDB.editScore(id, newFirstScoreX1, newSecondScoreX1, newScoreX2, newScoreX3);
            System.out.println("Edit successfully.");
        } else {
            System.out.println("Invalid id.");
        }

    }

    public void editStudent(int id, String newName, String newGender){
        studentDB.editStudent(id,newName,newGender);
    }


    public void printListSorted() {
        ArrayList<Student> arr = studentDB.sortedByGPA();
        for (Student student : arr) {
            if (student.getGpa() >= 8.5) {
                System.out.println(student.toString() + ". Academic performance: Very good!");
            } else  if (student.getGpa() >= 7.0) {
                System.out.println(student.toString() + ". Academic performance: Good!");
            } else if (student.getGpa() >= 5.5) {
                System.out.println(student.toString() + ". Academic performance: Average!");
            } else if (student.getGpa() >= 4.0) {
                System.out.println(student.toString() + ". Academic performance: Below average!");
            } else System.out.println(student.toString() + ". Academic performance: Weak!");
        }
    }

    public void loadFile() throws IOException {
        studentDB.readFile();
    }

}
