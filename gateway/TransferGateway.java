package com.example.cleanarch.gateway;

import com.example.cleanarch.domain.Transaction;

public interface TransferGateway {
    Boolean transferGateway(Transaction transaction);
}
