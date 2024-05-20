package com.example.kafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumers implements IKafkaConsumers {

    @KafkaListener(topics = "spark-channel", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }

}
