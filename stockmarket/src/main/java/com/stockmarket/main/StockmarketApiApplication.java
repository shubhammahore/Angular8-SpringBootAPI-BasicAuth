package com.stockmarket.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com"})
@ComponentScan("com.stockmarket")
@EnableJpaRepositories("com.stockmarket.repository")
@EntityScan("com.stockmarket.model")
@EnableJpaAuditing
public class StockmarketApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockmarketApiApplication.class, args);
		System.out.println(" Application is Running on Port 8080");
	}

}
