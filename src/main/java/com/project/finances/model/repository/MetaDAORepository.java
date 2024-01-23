package com.project.finances.model.repository;

import com.project.finances.model.entity.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetaDAORepository extends JpaRepository<Meta, Long> {
}
