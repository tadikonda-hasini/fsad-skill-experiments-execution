package com.klu.spring_skill5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String gender;

    @Autowired
    private Certification certification;   // AUTOWIRED

    public Student() {
        this.id = 30249;
        this.name = "Yasaswi";
        this.gender = "Female";
    }

    public void display() {
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Gender       : " + gender);
        System.out.println(certification);
    }
}
