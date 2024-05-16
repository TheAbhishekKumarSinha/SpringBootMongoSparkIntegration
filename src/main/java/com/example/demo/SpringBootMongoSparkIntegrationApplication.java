package com.example.demo;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoSparkIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoSparkIntegrationApplication.class, args);
		SparkSession sparkSession = SparkSession.builder()
		.master("local")
		.appName("MongoSparkConnectorIntro")
		.getOrCreate();

		JavaSparkContext javaSparkContext = new JavaSparkContext(sparkSession.sparkContext());
		Dataset dataframe = sparkSession.read().format("mongodb")
		.option("spark.mongodb.read.database", "test")
		.option("spark.mongodb.read.collection", "ITEMS")
		.option("spark.mongodb.read.connection.uri", "mongodb://localhost:27017").load();
		System.out.println(dataframe.toDF());
		dataframe.toDF().show();
	}

}
