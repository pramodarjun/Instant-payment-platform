package com.payments.processor.health;

import org.springframework.stereotype.Service;

@Service
public class PaymentLivenessService {

    /**
     * Simple liveness check method.
     * @return the string "Ok"
     */
    public String getLiveness() {
        return "Ok";
    }

}
