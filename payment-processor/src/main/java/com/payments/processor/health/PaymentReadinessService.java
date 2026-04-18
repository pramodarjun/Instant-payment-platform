package com.payments.processor.health;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class PaymentReadinessService {

    private final DataSource dataSource;

    public PaymentReadinessService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Attempts a lightweight validation against the configured DataSource.
     * Returns "Ready" when the DB is reachable and a validation query passes.
     * Throws IllegalStateException when the DB is unreachable or validation fails.
     */
    public String getReadiness() {
        try (Connection conn = dataSource.getConnection()) {
            boolean valid = false;
            try {
                valid = conn.isValid(2);
            } catch (AbstractMethodError | SQLException ignored) {
                // driver may not support isValid; fall back to simple query
            }

            if (!valid) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.executeQuery("SELECT 1");
                    valid = true;
                } catch (SQLException e) {
                    valid = false;
                }
            }

            if (valid) {
                return "Ready";
            }

            throw new IllegalStateException("Database validation query failed");
        } catch (SQLException e) {
            throw new IllegalStateException("Database unreachable", e);
        }
    }
}
