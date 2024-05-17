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
		SparkSession sparkSession = SparkSession.builder()
		.master("local")
		.appName("MongoSparkConnectorIntro")
		.getOrCreate();

		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		Dataset dataframe = sparkSession.read().format("mongodb")
		.option("spark.mongodb.read.database", "CAT_TRADING")
		.option("spark.mongodb.read.collection", "EnrichedInquiry")
		.option("spark.mongodb.read.connection.uri", "mongodb://localhost:27017").load();
		//dataframe.toDF().show();
	}

}
