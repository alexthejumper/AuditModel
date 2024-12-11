package com.example.auditmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class AuditModelApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditModelApplication.class, args);
    }

}
