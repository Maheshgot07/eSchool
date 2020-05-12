package com.mahi.school.eschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class EschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(EschoolApplication.class, args);
	}

}
