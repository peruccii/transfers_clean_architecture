package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Wallet;
import com.example.cleanarch.exception.NotFoundException;

public interface FindWalletByTaxNumberUseCase {
    Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException;
}
