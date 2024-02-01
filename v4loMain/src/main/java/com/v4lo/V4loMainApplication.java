package com.v4lo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class V4loMainApplication {
public class V4loMainApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(V4loMainApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(V4loMainApplication.class, args);
	}

}
