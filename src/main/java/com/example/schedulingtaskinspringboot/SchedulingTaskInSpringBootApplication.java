package com.example.schedulingtaskinspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SchedulingTaskInSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulingTaskInSpringBootApplication.class, args);
    }

}
