package com.payments.processor.consumer;

import com.payments.processor.producer.PaymentProcessedService;
import com.payments.processor.service.MetricsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class PaymentSubmittedService {

    private final PaymentProcessedService publisher;
    private final MetricsService metricsService;
    @Value("${spring.kafka.consumer.topic.payments-submitted}")
    private String submittedTopic;

    @Autowired
    public PaymentSubmittedService(PaymentProcessedService publisher, MetricsService metricsService) {
        this.publisher = publisher;
        this.metricsService = metricsService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer.topic.payments-submitted}", groupId = "${spring.kafka.consumer.group-id}")
    public void onRawPayment(String message,
                             Acknowledgment ack) {
        // measure processing time
        long start = System.nanoTime();

        // Basic processing placeholder
        String processed = process(message);


        long elapsed = System.nanoTime() - start;

        // acknowledge to commit offset
        if (ack != null) {
            ack.acknowledge();
        }
    }

    private String process(String raw) {

        return raw;
    }
}
