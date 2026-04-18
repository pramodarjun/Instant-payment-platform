package com.payments.processor.controller;


import com.payments.processor.health.PaymentReadinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class PaymentReadinessController {

    private final PaymentReadinessService paymentReadinessService;

    public PaymentReadinessController(PaymentReadinessService paymentReadinessService) {
        this.paymentReadinessService = paymentReadinessService;
    }

    /**
     * Endpoint to check payment system readiness.
     * Returns 200 OK with "Ready" message when the database is accessible.
     * Returns 503 Service Unavailable when the database is unreachable.
     */
    @GetMapping("/readiness")
    public ResponseEntity<String> getReadiness() {
        try {
            String readiness = paymentReadinessService.getReadiness();
            return ResponseEntity.ok(readiness);
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body("Service unavailable: " + e.getMessage());
        }
    }
}

