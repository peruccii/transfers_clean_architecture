package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.domain.TransactionPin;
import com.example.cleanarch.domain.User;
import com.example.cleanarch.domain.Wallet;
import com.example.cleanarch.exception.EmailException;
import com.example.cleanarch.exception.TaxNumberException;
import com.example.cleanarch.exception.TransactionPinException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;
import com.example.cleanarch.gateway.CreateUserGateway;
import com.example.cleanarch.usecase.*;


public class CreateUserUseCaseImpl implements CreateUserUseCase {

    private final TaxNumberAvailableUseCase taxNumberAvailableUseCase;

    private final EmailAvailableUseCase emailAvailableUseCase;

    private final CreateUserGateway createUserGateway;

    private final CreateWalletUseCase createWalletUseCase;

    private final CreateTransactionPinUseCase createTransactionPinUseCase;

    public CreateUserUseCaseImpl(TaxNumberAvailableUseCase taxNumberAvailableUseCase, EmailAvailableUseCase emailAvailableUseCase, CreateUserGateway createUserGateway, CreateWalletUseCase createWalletUseCase, CreateTransactionPinUseCase createTransactionPinUseCase) {
        this.taxNumberAvailableUseCase = taxNumberAvailableUseCase;
        this.emailAvailableUseCase = emailAvailableUseCase;
        this.createUserGateway = createUserGateway;
        this.createWalletUseCase = createWalletUseCase;
        this.createTransactionPinUseCase = createTransactionPinUseCase;
    }

    @Override
    public void createUser(User user, String pin) throws TaxNumberException, EmailException, TransactionPinException {
        if(!taxNumberAvailableUseCase.isTaxNumberAvailable(user.getTaxNumber().getValue()))
            throw new TaxNumberException(
                    ErrorCodeEnum.ON0003.getMessage(),
                    ErrorCodeEnum.ON0003.getCode()
            );

        if(!emailAvailableUseCase.isEmailAvailable(user.getEmail()))
            throw new EmailException(
                    ErrorCodeEnum.ON0002.getMessage(),
                    ErrorCodeEnum.ON0002.getCode());

        var userSaved = createUserGateway.createUserGateway(user);

        createWalletUseCase.createWallet(new Wallet(userSaved));
        createTransactionPinUseCase.createTransactionPin(new TransactionPin(userSaved, pin));
    }
}
