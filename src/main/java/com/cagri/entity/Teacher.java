package com.cagri.entity;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teacher {
    private String name;
    public static List<Student> studentList = new ArrayList<>();
    Manager manager = new Manager();

    public List<Student> getStudentsFromFile(String path){
          return manager.getStudents(path);
    }


    public void createTeacherfromManager() {
    manager.createTeacherFile(studentList, name);
    }


    public void readScoresAndMakeList() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\cagri\\IdeaProjects\\Java_HS1_StudentScoreAssessment\\src\\main\\resources\\ogrenciler.txt"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                manager.makeAstudentAndAddtoList(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public Teacher(String name, List<Student> studentList) {
        this.name = name;
        Teacher.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("name='").append(name).append('\'');
        sb.append(", studentList=").append(studentList);
        sb.append('}');
        return sb.toString();
    }
}
