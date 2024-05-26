package com.example.kafka.consumers;

import com.example.spark.request.SparkRequest;

public interface IKafkaConsumers {

    public void listen(SparkRequest request);
}
