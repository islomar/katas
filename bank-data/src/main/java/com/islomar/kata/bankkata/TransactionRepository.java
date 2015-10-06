package com.islomar.kata.bankkata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class TransactionRepository {

  private List<Transaction> listOfTransactions;

  public TransactionRepository() {
    listOfTransactions = new ArrayList<>();
  }

  public void addTransaction(Transaction transaction) {

    listOfTransactions.add(transaction);
  }

  public List<Transaction> findAll() {

    return listOfTransactions;
  }
}
