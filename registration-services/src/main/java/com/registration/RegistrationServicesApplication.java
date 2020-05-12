package com.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("common.datamodel")
public class RegistrationServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationServicesApplication.class, args);
	}
}
