package com.example.config;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.request.SparkRequest;


@Configuration
public class KafkaProducerConfig {
    
    @Bean
    public ProducerFactory<String, SparkRequest> producerFactory(){
        return new DefaultKafkaProducerFactory<String, SparkRequest>(producerConf());
    }

    @Bean
    public Map<String, Object> producerConf() {
        Map<String, Object> producerConf = new HashMap<>();
        producerConf.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        producerConf.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producerConf.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return producerConf;
    }

    @Bean
    @Qualifier
    public KafkaTemplate<String, SparkRequest> kafkaTemplate() {
        return new KafkaTemplate<String, SparkRequest>(producerFactory());
    }

    // @Bean
    // public KafkaTemplate<String, byte[]> bytesTemplate(ProducerFactory<String, byte[]> pf) {
    //     return new KafkaTemplate<>(pf,
    //             Collections.singletonMap(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class));
    // }
}