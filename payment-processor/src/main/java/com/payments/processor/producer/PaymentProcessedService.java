package com.payments.processor.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProcessedService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic.payments-processed}")
    private String processedTopic;

    public PaymentProcessedService(KafkaTemplate<String,String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishProcessed(String key, String payload) {
        kafkaTemplate.send(processedTopic, key, payload);
    }
}