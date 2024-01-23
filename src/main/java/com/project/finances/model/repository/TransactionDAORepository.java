package com.project.finances.model.repository;

import com.project.finances.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDAORepository extends JpaRepository<Transaction, Long> {
}
