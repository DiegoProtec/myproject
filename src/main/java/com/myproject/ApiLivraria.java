package com.myproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = {"com.myproject.repositorys"})
@EntityScan(basePackages = {"com.myproject.domain"})
public class ApiLivraria {

    public static void main(String[] args){
        SpringApplication.run(ApiLivraria.class, args);
    }

}
