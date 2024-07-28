package com.laplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class WikiMessageApp {
    public static void main(String[] args) {
        SpringApplication.run(WikiMessageApp.class, args);
    }
}