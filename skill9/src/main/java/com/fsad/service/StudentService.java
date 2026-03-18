package com.fsad.service;

import org.springframework.stereotype.Service;

import com.fsad.exception.StudentNotFoundException;
import com.fsad.model.Student;

@Service
public class StudentService {

    public Student getStudentById(int id) {

        if(id == 1)
            return new Student(249,"Yasaswi","CSE");

        if(id == 2)
            return new Student(792,"Hasini","CSE");

        throw new StudentNotFoundException("Student with ID "+id+" not found");
    }
}