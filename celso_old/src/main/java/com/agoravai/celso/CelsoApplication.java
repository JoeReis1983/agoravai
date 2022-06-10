package com.agoravai.celso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class CelsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CelsoApplication.class, args);
	}

}
