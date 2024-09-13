package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.domain.Wallet;
import com.example.cleanarch.exception.NotFoundException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;
import com.example.cleanarch.gateway.FindWalletByTaxNumberGateway;
import com.example.cleanarch.usecase.FindWalletByTaxNumberUseCase;

public class FindWalletByTaxNumberUseCaseImpl implements FindWalletByTaxNumberUseCase {

    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberUseCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException {
        var wallet =  findWalletByTaxNumberGateway.findWalletByTaxNumber(taxNumber);
        if (wallet == null) throw new NotFoundException(
                ErrorCodeEnum.WA0001.getMessage(),
                ErrorCodeEnum.WA0001.getCode()
        );
        return wallet;
    }
}
