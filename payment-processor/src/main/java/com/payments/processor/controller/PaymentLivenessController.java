package com.payments.processor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.payments.processor.health.PaymentLivenessService;
import com.payments.processor.health.PaymentReadinessService;

@RestController
@RequestMapping("/api/health")
public class PaymentLivenessController {

    private final PaymentLivenessService livenessService;

    @Autowired
    public PaymentLivenessController(PaymentLivenessService livenessService) {
        this.livenessService = livenessService;
    }

    @GetMapping("/liveness")
    public ResponseEntity<String> liveness() {
        return ResponseEntity.ok(livenessService.getLiveness());
    }
}
