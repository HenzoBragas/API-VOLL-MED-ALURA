package com.example.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiVollMedApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApiVollMedApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("Conexão feita, aplicação rodando");
	}

}
