package com.payments.processor.repository;

import com.payments.processor.model.PaymentOutcomes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PaymentProcessorRepository extends JpaRepository<PaymentOutcomes, UUID> {

    List<PaymentOutcomes> getPaymentsByStatus(String status);
}
