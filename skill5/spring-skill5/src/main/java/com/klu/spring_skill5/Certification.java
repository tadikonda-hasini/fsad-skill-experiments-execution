package com.klu.spring_skill5;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id;
    private String name;
    private String dateOfCompletion;

    public Certification() {
        this.id = 206;
        this.name = "Java Certification";
        this.dateOfCompletion = "10-Jan-2026";
    }

    @Override
    public String toString() {
        return "Certification [id = " + id +
               ", name = " + name +
               ", date = " + dateOfCompletion + "]";
    }
}
