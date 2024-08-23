package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Wallet;

import java.math.BigDecimal;

public interface CheckBalanceUseCase {
    BigDecimal checkBalance(Wallet wallet);
}
