package com.example.cleanarch.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.example.cleanarch.domain.enums.TransactionStatus;

public class Transaction {
  
  private Long id;

  private Wallet fromWallet;

  private Wallet toWallet;

  private BigDecimal amount;

  private TransactionStatus status;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public Transaction(Wallet fromWallet, Wallet toWallet, BigDecimal amount, TransactionStatus status,
      LocalDateTime createdAt) {
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Wallet getFromWallet() {
    return fromWallet;
  }

  public void setFromWallet(Wallet fromWallet) {
    this.fromWallet = fromWallet;
  }

  public Wallet getToWallet() {
    return toWallet;
  }

  public void setToWallet(Wallet toWallet) {
    this.toWallet = toWallet;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public TransactionStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionStatus status) {
    this.status = status;
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
