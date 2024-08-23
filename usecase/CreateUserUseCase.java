package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.User;
import com.example.cleanarch.exception.EmailException;
import com.example.cleanarch.exception.TaxNumberException;
import com.example.cleanarch.exception.TransactionPinException;

public interface CreateUserUseCase  {
    void createUser(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException;
}
