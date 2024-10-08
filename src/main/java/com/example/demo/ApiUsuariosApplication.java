package com.example.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class ApiUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuariosApplication.class, args);
	}

}
