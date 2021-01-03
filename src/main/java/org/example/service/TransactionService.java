package org.example.service;

import org.example.model.Transaction;
import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final List<Transaction> transactions = new CopyOnWriteArrayList<>(); // (1)

    public TransactionService() {
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(Integer amount, String reference){
        ZonedDateTime timestamp = ZonedDateTime.now();
        Transaction transaction = new Transaction(amount, reference, timestamp);
        transactions.add(transaction);
        return transaction;
    }
}
