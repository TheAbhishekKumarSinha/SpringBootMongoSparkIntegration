package com.example.kafka.producers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.example.spark.request.SparkRequest;
import com.example.spark.response.SparkResponse;


@Component
public class KafkaProducers implements IKafkaProducers{

    @Autowired
    private KafkaTemplate<String, SparkRequest> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, SparkResponse> kafkaResponseTemplate;
    
    public void sendToKafka(final SparkRequest data) {
        //final ProducerRecord<String, String> record = createRecord(data);
    
        CompletableFuture<SendResult<String, SparkRequest>> future = kafkaTemplate.send("spark-channel", data);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                //handleSuccess(data);
            }
            else {
                //handleFailure(data, record, ex);
            }
        });
    }

    @Override
    public void sendToKafka(SparkResponse data) {
        // TODO Auto-generated method stub
        CompletableFuture<SendResult<String, SparkResponse>> future = kafkaResponseTemplate.send("spark-channel", data);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                //handleSuccess(data);
            }
            else {
                //handleFailure(data, record, ex);
            }
        });
    }
}
