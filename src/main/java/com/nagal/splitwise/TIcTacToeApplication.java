package com.nagal.splitwise;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.nagal.splitwise")
public class TIcTacToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TIcTacToeApplication.class, args);
	}
}
