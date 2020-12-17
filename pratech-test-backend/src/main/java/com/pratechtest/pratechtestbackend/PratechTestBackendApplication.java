package com.pratechtest.pratechtestbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EnableAutoConfiguration
@EntityScan(basePackages = {"com.pratechtest.entity"})
@SpringBootApplication
public class PratechTestBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PratechTestBackendApplication.class, args);
	}

}
