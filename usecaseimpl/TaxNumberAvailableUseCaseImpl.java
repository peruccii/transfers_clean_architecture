package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.gateway.TaxNumberAvailableGateway;
import com.example.cleanarch.usecase.TaxNumberAvailableUseCase;

public class TaxNumberAvailableUseCaseImpl implements TaxNumberAvailableUseCase {

    private final TaxNumberAvailableGateway taxNumberAvailableGateway;

    public TaxNumberAvailableUseCaseImpl(TaxNumberAvailableGateway taxNumberAvailableGateway) {
        this.taxNumberAvailableGateway = taxNumberAvailableGateway;
    }

    @Override
    public Boolean isTaxNumberAvailable(String taxNumber) {
        return null;
    }
}
