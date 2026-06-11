package com.pragma.transactions.domain;

import com.pragma.transactions.infrastructure.TransactionRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Mono<String> processTransaction(String channel, double amount, String idempotencyKey) {
        return transactionRepository.saveTransaction(channel, amount, idempotencyKey);
    }
}