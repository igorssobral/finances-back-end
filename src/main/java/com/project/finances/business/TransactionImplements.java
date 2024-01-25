package com.project.finances.business;

import com.project.finances.business.interfaces.TransactionService;
import com.project.finances.model.entity.Transaction;
import com.project.finances.model.repository.TransactionDAORepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;
import java.util.Optional;

public class TransactionImplements implements TransactionService {

    private TransactionDAORepository transactionRepository;
    @Override
    public Transaction save(Transaction transaction) {
        if (transaction.getId() != null) {
            throw new IllegalStateException("The user already exists in the database.");
        }

        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        if (transaction.getId() == null) {
            throw new IllegalStateException("Id cannot be null");
        }
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> find(Transaction filter) {

        Example<Transaction> filters = Example.of(filter,
                ExampleMatcher.matching()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));


        return transactionRepository.findAll(filters);
    }

    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findByName(String name) {

        if (name == null) {
            throw new IllegalStateException("Name cannot be null!");
        }

        Transaction transactionFind = null;

        List<Transaction> allTransactions = transactionRepository.findAll();
        for (int i = 0; i < allTransactions.size(); i++) {
            if (allTransactions.get(i).getName().equals(name)) {
                transactionFind = allTransactions.get(i);
            }
        }

        return transactionFind;
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
        }

        Transaction transaction = findById(id);

        if (transaction == null) {
            throw new IllegalStateException(String.format("Could not find a entity with id=%l", id));
        }
        transactionRepository.delete(transaction);
    }

    @Override
    public Transaction findById(Long id) {

        if (id == null) {
            throw new IllegalStateException("Id cannot be null!");
        }

        Optional<Transaction> optional = transactionRepository.findById(id);


        return optional.isPresent() ? optional.get() : null;
    }
}