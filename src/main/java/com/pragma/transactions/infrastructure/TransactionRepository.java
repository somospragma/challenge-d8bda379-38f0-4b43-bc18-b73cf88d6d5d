package com.pragma.transactions.infrastructure;

import reactor.core.publisher.Mono;

public interface TransactionRepository {
    Mono<String> saveTransaction(String channel, double amount, String idempotencyKey);
}