package com.example.kafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.spark.request.SparkRequest;


@Component
public class KafkaConsumers implements IKafkaConsumers {

    @KafkaListener(topics = "spark-channel", groupId = "my-group-id")
    public void listen(SparkRequest message) {
        System.out.println("Received message: " + message);
    }

}
