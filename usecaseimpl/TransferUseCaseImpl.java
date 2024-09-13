package com.example.cleanarch.usecaseimpl;


import com.example.cleanarch.domain.Transaction;
import com.example.cleanarch.domain.Wallet;
import com.example.cleanarch.exception.InternalServerErrorException;
import com.example.cleanarch.exception.TransferException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;
import com.example.cleanarch.gateway.TransferGateway;
import com.example.cleanarch.usecase.CreateTransactionUseCase;
import com.example.cleanarch.usecase.FindWalletByTaxNumberUseCase;
import com.example.cleanarch.usecase.TransactionValidateUseCase;
import com.example.cleanarch.usecase.TransferUseCase;

import java.math.BigDecimal;

public class TransferUseCaseImpl implements TransferUseCase {

    private final FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase;

    private final TransactionValidateUseCase transactionValidateUseCase;

    private final CreateTransactionUseCase createTransactionUseCase;

    private final TransferGateway transferGateway;

    public TransferUseCaseImpl(FindWalletByTaxNumberUseCase findWalletByTaxNumberUseCase, TransactionValidateUseCase transactionValidateUseCase, CreateTransactionUseCase createTransactionUseCase, TransferGateway transferGateway) {
        this.findWalletByTaxNumberUseCase = findWalletByTaxNumberUseCase;
        this.transactionValidateUseCase = transactionValidateUseCase;
        this.createTransactionUseCase = createTransactionUseCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String fromTaxNumber, String toTaxNumber, BigDecimal value) throws InternalServerErrorException, TransferException {
        Wallet from = findWalletByTaxNumberUseCase.findWalletByTaxNumber(fromTaxNumber);
        Wallet to = findWalletByTaxNumberUseCase.findWalletByTaxNumber(toTaxNumber);

        from.transferValue(value);
        to.receiveValue(value);

        var transaction = createTransactionUseCase.createTransaction(new Transaction(from, to, value));

        transactionValidateUseCase.validateTransaction(transaction);

        if (!transferGateway.transferGateway(transaction)) throw new InternalServerErrorException(
                ErrorCodeEnum.TR0003.getMessage(),
                ErrorCodeEnum.TR0003.getCode()
        );

        return true;
    }
}
