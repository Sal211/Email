package com.example.email2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Email2Application {

	public static void main(String[] args) {
		SpringApplication.run(Email2Application.class, args);
	}

}
