package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.domain.Wallet;
import com.example.cleanarch.usecase.CreateWalletUseCase;

public class CreateWalletUseCaseImpl implements CreateWalletUseCase {

    private final CreateWalletUseCase createWalletUseCase;

    public CreateWalletUseCaseImpl(CreateWalletUseCase createWalletUseCase) {
        this.createWalletUseCase = createWalletUseCase;
    }

    @Override
    public void createWallet(Wallet wallet) {



        createWalletUseCase.createWallet(wallet);
    }
}
