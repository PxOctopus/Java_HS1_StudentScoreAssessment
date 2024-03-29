package com.cagri;

import com.cagri.entity.Manager;
import com.cagri.entity.Student;
import com.cagri.entity.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.cagri.entity.Teacher.studentList;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        ///////////////========================== MANAGER CLASS METHODS' RUN==================================//////////////////////////
        Manager manager = new Manager();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\cagri\\IdeaProjects\\Java_HS1_StudentScoreAssessment\\src\\main\\resources\\ogrenciler.txt"));

        List<Student> studentList = manager.readFromFile("Hatice", reader);
        System.out.println(studentList);

        manager.createTeacherFile(studentList, "Orhan");

        List<String> scores = List.of("87", "54", "65", "89", "70");
        System.out.println(manager.scoresAverage(scores));


        //////////////============================TEACHER CLASS METHODS' RUN================================//////////////////////////
        Teacher teacher = new Teacher("Selcuk", studentList);
        teacher.readScoresAndMakeList();
        System.out.println(studentList);
        teacher.createTeacherfromManager();

        System.out.println(teacher.getStudentsFromFile("C:\\Users\\cagri\\IdeaProjects\\Java_HS1_StudentScoreAssessment\\src\\main\\resources\\Selcuk.txt"));



    }
}
