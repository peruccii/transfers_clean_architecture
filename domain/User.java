package com.example.cleanarch.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.example.cleanarch.domain.enums.UserTypeEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private UUID id;

    private String email;

    private String password;

    private TaxNumber taxNumber;

    private Boolean isFirstLogin = true;

    private String fullName;

    private UserTypeEnum type;

    private TransactionPin transactionPin;

    private LocalDateTime createdAt;

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserTypeEnum type,
            TransactionPin transactionPin, LocalDateTime createdAt) {
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
    }

    public User(UUID id, String email, String password, TaxNumber taxNumber, Boolean isFirstLogin, String fullName, UserTypeEnum type,
            TransactionPin transactionPin, LocalDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.isFirstLogin = isFirstLogin;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = createdAt;
    }

    public User() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(taxNumber, user.taxNumber) && Objects.equals(isFirstLogin, user.isFirstLogin) && Objects.equals(fullName, user.fullName) && type == user.type && Objects.equals(transactionPin, user.transactionPin) && Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, taxNumber, isFirstLogin, fullName, type, transactionPin, createdAt);
    }
}
