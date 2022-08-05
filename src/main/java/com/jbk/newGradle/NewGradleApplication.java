package com.jbk.newGradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewGradleApplication.class, args);
	}

}
