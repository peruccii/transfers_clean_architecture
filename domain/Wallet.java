package com.example.cleanarch.domain;

import com.example.cleanarch.domain.enums.UserTypeEnum;
import com.example.cleanarch.exception.TransferException;
import com.example.cleanarch.exception.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Wallet {

    private Long id;

    private BigDecimal balance;

    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Wallet(User user) {
        this.balance = BigDecimal.ZERO;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Wallet() {
    }

    public void verifyTypeUser() throws TransferException {
        if (this.user.getType() == UserTypeEnum.SHOPKEEPER) throw new TransferException(
                ErrorCodeEnum.TR0001.getMessage(),
                ErrorCodeEnum.TR0001.getCode());
    }

    public void verifyBalance(BigDecimal value) throws TransferException {
        if (this.balance.compareTo(value) <= 0) throw new  TransferException(
                ErrorCodeEnum.TR0002.getMessage(),
                ErrorCodeEnum.TR0002.getCode());
    }

    public void receiveValue(BigDecimal value) {
      this.balance.add(value);
    }

    public void transferValue(BigDecimal value) throws TransferException {
      verifyTypeUser();
      verifyBalance(value);

      this.balance.subtract(value);
    }

}
