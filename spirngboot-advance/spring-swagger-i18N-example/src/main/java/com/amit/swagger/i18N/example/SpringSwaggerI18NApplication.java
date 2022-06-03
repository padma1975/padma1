package com.amit.swagger.i18N.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringSwaggerI18NApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSwaggerI18NApplication.class, args);
    }
}
