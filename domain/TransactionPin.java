package com.example.cleanarch.domain;

import com.example.cleanarch.exception.TransactionPinException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;

import java.time.LocalDateTime;

public class TransactionPin {
    private Long id;

    private User user;

    private String pin;

    private String attempt;

    private Boolean blocked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TransactionPin(Long id, User user, String pin, String attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user, String pin, String attempt, Boolean blocked) {
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        isValidPin(pin);
        this.pin = pin;
    }

    private void isValidPin(String pin) throws TransactionPinException {
        if(pin.length() != 8) throw new TransactionPinException(
                ErrorCodeEnum.TRP0001.getMessage(),
                ErrorCodeEnum.TRP0001.getCode());
    }

    public String getAttempt() {
        return attempt;
    }

    public void setAttempt(String attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
