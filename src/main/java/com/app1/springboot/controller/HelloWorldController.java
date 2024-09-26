package com.app1.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//make it into a spring MVC controller with @controller


//rest returns json to the client
//response body annotation to convert java -> json
///RestController = Controller + ResponseBody


@RestController
public class HelloWorldController {


    //create a method and use spring annotations to make it an API
    //HTTP GET REQUEST
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";

    }
}
