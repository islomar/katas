package com.islomar.kata.bankkata;


import java.time.LocalDateTime;

/**
 *   Immutable representation of a bank transaction.
 */
public class Transaction {

  private final LocalDateTime date;
  private final int amount;

  public Transaction(LocalDateTime now, int amount) {

    date = now;
    this.amount = amount;
  }

  public int getAmount() {

    return amount;
  }

  public LocalDateTime getDate() {

    return date;
  }

}
