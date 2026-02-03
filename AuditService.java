package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.BankRepository;

@Service
public class AuditService {

    private final BankRepository bankRepository;

    public AuditService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String message) {
        bankRepository.insertAudit(message);
    }
}
