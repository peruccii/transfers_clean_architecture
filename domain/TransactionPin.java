package com.example.cleanarch.domain;

import com.example.cleanarch.exception.TransactionPinException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionPin {
    private Long id;

    private User user;

    private String pin;

    private Integer attempt;

    private Boolean blocked;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TransactionPin(Long id, User user, String pin, Integer attempt, Boolean blocked, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.pin = pin;
        this.attempt = attempt;
        this.blocked = blocked;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public TransactionPin(User user, String pin) throws TransactionPinException {
        this.user = user;
        this.setPin(pin);
        this.attempt = 3;
        this.blocked = false;
        this.createdAt = LocalDateTime.now();
    }

    public TransactionPin() {}


    public void setPin(String pin) throws TransactionPinException {
        isValidPin(pin);
        this.pin = pin;
    }

    private void isValidPin(String pin) throws TransactionPinException {
        if(pin.length() != 8) throw new TransactionPinException(
                ErrorCodeEnum.TRP0001.getMessage(),
                ErrorCodeEnum.TRP0001.getCode());
    }
}
