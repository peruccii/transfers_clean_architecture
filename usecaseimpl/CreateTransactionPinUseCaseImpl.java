package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.domain.TransactionPin;
import com.example.cleanarch.gateway.CreateTransactionPinGateway;
import com.example.cleanarch.usecase.CreateTransactionPinUseCase;

public class CreateTransactionPinUseCaseImpl implements CreateTransactionPinUseCase {

    private final CreateTransactionPinGateway createTransactionPinGateway;

    public CreateTransactionPinUseCaseImpl(CreateTransactionPinGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void createTransactionPin(TransactionPin transactionPin) {
        createTransactionPinGateway.createTransactionPinGateway(transactionPin);
    }
}
