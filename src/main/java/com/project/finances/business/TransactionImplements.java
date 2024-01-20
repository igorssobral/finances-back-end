package com.project.finances.business;

import com.project.finances.business.interfaces.TransactionService;
import com.project.finances.model.entity.Transaction;

import java.util.List;

public class TransactionImplements implements TransactionService {
    @Override
    public Transaction save(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction update(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> find(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public List<Transaction> findByName(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Transaction findById(Long id) {
        return null;
    }
}
