package com.example.kafka.consumers;

import com.example.request.SparkRequest;

public interface IKafkaConsumers {

    public void listen(SparkRequest request);
}
