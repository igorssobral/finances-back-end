package com.project.finances.business.interfaces;

import com.project.finances.model.entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction save(Transaction transaction);

    public Transaction update(Transaction transaction);

    public List<Transaction> find(Transaction transaction);

    public List<Transaction> findAll();

    public List<Transaction> findByName(String name);

    public void delete(Long id);

    public Transaction findById(Long id);

}
