package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Transaction;

public interface TransferUseCase {
    Boolean transfer(Transaction transaction);
}
