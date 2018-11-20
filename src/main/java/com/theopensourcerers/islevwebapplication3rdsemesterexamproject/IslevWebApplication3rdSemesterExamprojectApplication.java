package com.theopensourcerers.islevwebapplication3rdsemesterexamproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IslevWebApplication3rdSemesterExamprojectApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(IslevWebApplication3rdSemesterExamprojectApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(IslevWebApplication3rdSemesterExamprojectApplication.class, args);
	}
}
