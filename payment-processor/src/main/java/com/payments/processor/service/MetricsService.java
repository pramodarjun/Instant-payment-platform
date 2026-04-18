package com.payments.processor.service;

import com.payments.processor.model.PaymentOutcomes;
import com.payments.processor.repository.PaymentProcessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MetricsService {
    
    private final PaymentProcessorRepository repository;

    @Autowired
    public MetricsService(PaymentProcessorRepository repository) {
        this.repository = repository;
    }

    public List<PaymentOutcomes> getTotalProcessed(String status) {
        return repository.getPaymentsByStatus(status);
    }

    public List<PaymentOutcomes> getTotalHeld(String status) {
        return repository.getPaymentsByStatus(status);
    }

    public List<PaymentOutcomes> getTotalRejected(String status) {
        return repository.getPaymentsByStatus(status);
    }
}

