package com.example.cleanarch.gateway;

import com.example.cleanarch.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findWalletByTaxNumber(String taxNumber);
}
