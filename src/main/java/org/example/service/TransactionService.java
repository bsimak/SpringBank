package org.example.service;

import org.example.model.Transaction;
import org.springframework.stereotype.Component;

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

        System.out.println("in create Transaction - Amount: " + amount);
        if (amount < 0) {
            throw new IllegalStateException();
        }
        Transaction transaction = new Transaction(amount, reference);
        transactions.add(transaction);
        return transaction;
    }
}
