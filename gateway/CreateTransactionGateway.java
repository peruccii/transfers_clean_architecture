package com.example.cleanarch.gateway;

import com.example.cleanarch.domain.Transaction;

public interface CreateTransactionGateway {
    void createTransaction(Transaction transaction);
}
