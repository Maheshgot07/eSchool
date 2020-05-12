package com.mahi.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("common.datamodel")
public class PaymentServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class,args);
	}

}
