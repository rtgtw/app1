package com.app1.springboot.controller;

import com.app1.springboot.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    @GetMapping("student")
    public Student getStudent(){

        Student student1 = new Student(1, "Bob", "Johnson");
        return student1;
    }
}
