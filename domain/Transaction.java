package com.example.cleanarch.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.example.cleanarch.domain.enums.TransactionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
  
  private Long id;

  private Wallet fromWallet;

  private Wallet toWallet;

  private BigDecimal amount;

  private TransactionStatus status;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal amount) {
    this.fromWallet = fromWallet;
    this.toWallet = toWallet;
    this.amount = amount;
    this.status = TransactionStatus.CREATED;
    this.createdAt = LocalDateTime.now();
  }

  public Transaction(Long id, Wallet fromWallet, Wallet toWallet, BigDecimal amount, TransactionStatus status,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.fromWallet = fromWallet;
    this.toWallet = toWallet;
    this.amount = amount;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Transaction(){}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Objects.equals(id, that.id) && Objects.equals(fromWallet, that.fromWallet) && Objects.equals(toWallet, that.toWallet) && Objects.equals(amount, that.amount) && status == that.status && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromWallet, toWallet, amount, status, createdAt);
  }
}
