package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot10MailtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10MailtestApplication.class, args);
    }

}
