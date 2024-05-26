package com.example.spark;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkContext{
    
    @Bean
    public SparkConf  sparkConf() {
        SparkConf conf= new SparkConf().setAppName("Java Spark").setMaster("local[*]");
        return conf;
    }

    @Bean
    public SparkSession sparkSession(){
        SparkSession spark = SparkSession
            .builder()
            .config(sparkConf())
            .getOrCreate();
        return spark;
    }

    
    
     
}