package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.BankRepository;

@Service
public class BankService {

    private final BankRepository bankRepository;
    private final AuditService auditService;

    public BankService(BankRepository bankRepository, AuditService auditService) {
        this.bankRepository = bankRepository;
        this.auditService = auditService;
    }

    @Transactional
    public void transfer(int fromId, int toId, int amount, boolean failAfterDebit) {

        auditService.log(
                "TRANSFER START : from " + fromId +
                ", to = " + toId +
                ", amount = " + amount
        );

        int fromBalance = bankRepository.getBalance(fromId);
        int toBalance = bankRepository.getBalance(toId);

        if (fromBalance < amount) {
            auditService.log("TRANSFER FAILED : Due to insufficient balance");
            throw new RuntimeException("Insufficient Balance");
        }

        // Debit (inside main transaction)
        bankRepository.updateBalance(fromId, fromBalance - amount);

        if (failAfterDebit) {
            auditService.log("TRANSFER FAILED : simulated error after debit");
            throw new RuntimeException("Simulated failure after debit");
        }

        // Credit
        bankRepository.updateBalance(toId, toBalance + amount);

        auditService.log("TRANSFER SUCCESS");
    }
}
