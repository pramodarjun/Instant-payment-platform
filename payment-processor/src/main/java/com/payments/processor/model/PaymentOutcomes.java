package com.payments.processor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_outcomes")
public class PaymentOutcomes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private UUID paymentId;
    private String debitAccountId;
    private String creditAccountId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private Timestamp processedAt;
    private Long processingTimeMs;
}