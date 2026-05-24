package com.kattus.noWebTestingProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NoWebTestingProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NoWebTestingProjectApplication.class, args);
		Dev dev = context.getBean(Dev.class);
		dev.build();
	}

}
