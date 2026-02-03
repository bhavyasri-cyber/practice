package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankRepository {

    private final JdbcTemplate jdbcTemplate;

    public BankRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getBalance(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT balance FROM accounts WHERE id = ?",
                Integer.class,
                id
        );
    }

    public void updateBalance(int id, int newBalance) {
        jdbcTemplate.update(
                "UPDATE accounts SET balance = ? WHERE id = ?",
                newBalance,
                id
        );
    }

    public void insertAudit(String message) {
        jdbcTemplate.update(
                "INSERT INTO audit_logs (message) VALUES (?)",
                message
        );
    }

    public List<Map<String, Object>> getAllAccounts() {
        return jdbcTemplate.queryForList(
                "SELECT * FROM accounts ORDER BY id"
        );
    }

    public List<Map<String, Object>> getAllAudits() {
        return jdbcTemplate.queryForList(
                "SELECT * FROM audit_logs ORDER BY id"
        );
    }
}
