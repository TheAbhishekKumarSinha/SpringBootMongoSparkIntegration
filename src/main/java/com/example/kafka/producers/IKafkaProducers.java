package com.example.kafka.producers;

import com.example.spark.request.SparkRequest;

public interface IKafkaProducers {

    public void sendToKafka(final SparkRequest data);

}
