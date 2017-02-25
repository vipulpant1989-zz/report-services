package com.bbt.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bbt")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// @Override
	// protected SpringApplicationBuilder configure(final
	// SpringApplicationBuilder application) {
	//
	// return application.sources(Application.class);
	// }
	
}
