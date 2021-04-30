package com.StudentManagement.dal;

import com.StudentManagement.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class StudentDB {
    public static ArrayList<Student> students;
    public static int count;
    static {
        count = 0;
        students = new ArrayList<>();
    }
    public static final String PATH = "student_list.csv";



    public void createFile() throws IOException {
        File file = new File(PATH);
        if (file.exists()) {
            System.out.println("File is already exists.");
        } else {
            file.createNewFile();
        }
    }

    public Student getId(int id){
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) return students.get(i);
        }
        return null;
    }

    public void writeFile() throws IOException {
        createFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(PATH));

        for (int i = 0; i < students.size(); i++) {
            bufferedWriter.write(students.get(i).toStringCSV());
        }
        bufferedWriter.close();
    }

    public void readFile() throws IOException {
        createFile();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH));

        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] arr = line.split(",");
            add(new Student(Integer.parseInt(arr[0]), arr[1], arr[2], Double.parseDouble(arr[3]), Double.parseDouble(arr[4]), Double.parseDouble(arr[5]), Double.parseDouble(arr[6]), Double.parseDouble(arr[7])));
        }
        bufferedReader.close();
    }

    public void add(Student student) {

        student.setId(count++);
        students.add(student);
    }

    public void editScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3) throws IOException {
        if (getId(id) != null){

            getId(id).setFirstScoreX1(newFirstScoreX1);
            getId(id).setSecondScoreX1(newSecondScoreX1);
            getId(id).setScoreX2(newScoreX2);
            getId(id).setScoreX3(newScoreX3);
            getId(id).setGpa((getId(id).getFirstScoreX1() + getId(id).getSecondScoreX1() + getId(id).getScoreX2()*2 + getId(id).getScoreX3()*3)/7);
            writeFile();
        } else {
            System.out.println("Invalid id.");
        }
    }

    public void editStudent(int id, String newName, String newGender){
        if (getId(id) != null){
            getId(id).setName(newName);
            getId(id).setGender(newGender);
            System.out.println("Edit successfully.");
        } else {
            System.out.println("Invalid id.");
        }
    }

    public void putScore(int id, double newFirstScoreX1, double newSecondScoreX1, double newScoreX2, double newScoreX3 ) throws IOException {
        if (getId(id) != null){
            getId(id).setFirstScoreX1(newFirstScoreX1);
            getId(id).setSecondScoreX1(newSecondScoreX1);
            getId(id).setScoreX2(newScoreX2);
            getId(id).setScoreX3(newScoreX3);
            getId(id).setGpa((getId(id).getFirstScoreX1() + getId(id).getSecondScoreX1() + getId(id).getScoreX2()*2 + getId(id).getScoreX3()*3)/7);
            writeFile();
        } else {
            System.out.println("Invalid id.");
        }
    }

    public boolean remove(int id) throws IOException {
        if (getId(id) != null){
            students.remove(id);
            writeFile();
            return true;
        } else {
            System.out.println("Invalid id.");
            return false;
        }
    }

    public void printList(){
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        System.out.println();
    }

    public ArrayList<Student> sortedByGPA() {

        ArrayList<Student> newArr = students;
        newArr.sort((o1, o2) -> {
            if (o1.getGpa() - o2.getGpa() > 0) {
                return 1;
            } else if (o1.getGpa() - o2.getGpa() < 0) {
                return -1;
            } else return 0;
        });
        return newArr;
    }

}
