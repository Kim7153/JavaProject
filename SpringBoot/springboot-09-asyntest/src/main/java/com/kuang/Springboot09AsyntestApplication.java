package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Springboot09AsyntestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsyntestApplication.class, args);
    }

}
