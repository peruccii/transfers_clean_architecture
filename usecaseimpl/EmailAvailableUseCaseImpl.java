package com.example.cleanarch.usecaseimpl;

import com.example.cleanarch.gateway.EmailAvailableGateway;
import com.example.cleanarch.usecase.EmailAvailableUseCase;

public class EmailAvailableUseCaseImpl implements EmailAvailableUseCase {

    private final EmailAvailableGateway emailAvailableGateway;

    public EmailAvailableUseCaseImpl(EmailAvailableGateway emailAvailableGateway) {
        this.emailAvailableGateway = emailAvailableGateway;
    }

    @Override
    public Boolean isEmailAvailable(String email) {
        return emailAvailableGateway.isEmailAvailable(email);
    }
}
