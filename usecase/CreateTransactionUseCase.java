package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Transaction;

public interface CreateTransactionUseCase {
    Transaction createTransaction(Transaction transaction);
}
