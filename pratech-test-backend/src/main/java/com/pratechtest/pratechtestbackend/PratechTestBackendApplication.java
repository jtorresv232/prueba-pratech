package com.pratechtest.pratechtestbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pratechtest.pratechtestbackend.entity"})
@SpringBootApplication
public class PratechTestBackendApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/test");
		SpringApplication.run(PratechTestBackendApplication.class, args);
	}

}
