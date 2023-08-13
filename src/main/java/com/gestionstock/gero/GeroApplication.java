package com.gestionstock.gero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeroApplication.class, args);
	}

}
