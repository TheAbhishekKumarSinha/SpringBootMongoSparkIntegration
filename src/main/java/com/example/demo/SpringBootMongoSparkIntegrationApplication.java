package com.example.demo;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
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
