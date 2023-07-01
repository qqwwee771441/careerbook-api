package com.teammansasung.notalkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NotalkApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotalkApiApplication.class, args);
    }

}
