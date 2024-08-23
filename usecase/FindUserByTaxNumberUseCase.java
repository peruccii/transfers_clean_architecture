package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.User;

public interface FindUserByTaxNumberUseCase {
    User findUserByTaxNumber(String taxNumber);
}
