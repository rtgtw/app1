package com.app1.springboot.controller;

import com.app1.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    static private int counter = 1;


    @GetMapping("student")
    public Student getStudent(){

        Student student1 = new Student(1, "Bob", "Johnson");
        return student1;
    }



    //Returns a list of objects
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(2,"billy", "joe"));
        students.add(new Student(3,"cameren","shaw"));
        students.add(new Student(55,"Gabe", "wolmack"));
        students.add(new Student(25,"Alan", "Cambell"));

        return students;
    }


    //Handles path variables
    //Binds
    //{id} URI template variable
    //Goal is to bind the template variable into the method argument id
    //This is done with the pathvariable annotation
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int id, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(id,firstName,lastName);
    }


    //RequestParam = query parameters
    //Extracts information
    //  localhost:8080/students?id=1
    @GetMapping("/students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, String lastName){
        return new Student(id, firstName,lastName);
    }


    //REST API that handles HTTP POST REQUESTS
    //PostMapping and @RequestBody
    //@RequestBody retrieves JSON body from HTTP request and converts it to a java object
    //Should return 201 created HTTP status code
    //@ResponseStatus

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){

        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        System.out.println(counter++);
        return student;
    }

    //put request updates resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


}
