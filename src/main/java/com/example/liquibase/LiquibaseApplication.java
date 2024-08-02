package com.example.liquibase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class LiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiquibaseApplication.class, args);
	}

}
