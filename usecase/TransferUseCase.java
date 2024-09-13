package com.example.cleanarch.usecase;


import com.example.cleanarch.exception.InternalServerErrorException;
import com.example.cleanarch.exception.TransferException;

import java.math.BigDecimal;

public interface TransferUseCase {
    Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException;
}
