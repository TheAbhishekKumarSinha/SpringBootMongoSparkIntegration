package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.repositories.StockRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses=StockRepository.class)
@ComponentScan("com.example.*")
public class SpringBootMongoSparkIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoSparkIntegrationApplication.class, args);
		
	}

}
