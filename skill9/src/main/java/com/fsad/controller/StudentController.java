package com.fsad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fsad.exception.InvalidInputException;
import com.fsad.model.Student;
import com.fsad.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch(NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number");
        }

        return studentService.getStudentById(studentId);
    }
}