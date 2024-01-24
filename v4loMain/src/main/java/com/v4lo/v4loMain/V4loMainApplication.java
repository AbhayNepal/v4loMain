package com.v4lo.v4loMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.v4lo")
public class V4loMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(V4loMainApplication.class, args);
	}

}
