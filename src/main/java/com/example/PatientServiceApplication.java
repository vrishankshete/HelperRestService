package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientServiceApplication {

	public static void main(String[] args) {
		System.out.println("Enetred main");
		SpringApplication.run(PatientServiceApplication.class, args);
	}
}
