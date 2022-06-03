package com.amit.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootActuatorExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActuatorExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunnerBean() {
		return (args) -> {
			System.out.println("In CommandLineRunnerImpl ");
			for (String arg : args) {
				System.out.println(arg);
			}
		};
	}

}
