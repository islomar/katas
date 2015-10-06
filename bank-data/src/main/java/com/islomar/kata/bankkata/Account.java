package com.islomar.kata.bankkata;

import java.time.LocalDateTime;
import java.util.List;

public class Account {

  private final TransactionRepository transactionRepository;
  private final Console console;

  public Account(TransactionRepository transactionRepository, Console console) {
    this.transactionRepository = transactionRepository;
    this.console = console;
  }

  public void deposit(int amount) {

    Transaction transaction = new Transaction(LocalDateTime.now(), amount);
    transactionRepository.addTransaction(transaction);
  }

  public void withdraw(int amount) {

    Transaction transaction = new Transaction(LocalDateTime.now(), -amount);
    transactionRepository.addTransaction(transaction);
  }

  public void printStatement() {

    List<Transaction> allTransactions = transactionRepository.findAll();
    TransactionFormatter transactionFormatter = new TransactionFormatter();
    transactionFormatter.printTransactions(allTransactions);

    console.printLine();
  }

}
