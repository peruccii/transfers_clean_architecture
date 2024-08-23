package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Transaction;

public interface TransactionValidateUseCase {
    Boolean validateTransaction(Transaction transaction);
}
