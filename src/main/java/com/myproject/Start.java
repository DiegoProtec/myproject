package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Start {

    @RequestMapping("/")
    @ResponseBody
    public String hello(){
        return "Hello world!";
    }

    public static void main(String[] args){
        SpringApplication.run(Start.class, args);
    }
}
