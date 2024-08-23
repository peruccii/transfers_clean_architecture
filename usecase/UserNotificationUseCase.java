package com.example.cleanarch.usecase;

import com.example.cleanarch.domain.Transaction;

public interface UserNotificationUseCase {
    Boolean notificateUser(Transaction transaction, String email);
}
