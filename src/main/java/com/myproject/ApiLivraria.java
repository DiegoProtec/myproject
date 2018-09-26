package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.myproject.models"})
public class ApiLivraria {

    public static void main(String[] args){
        SpringApplication.run(ApiLivraria.class, args);
    }

}
