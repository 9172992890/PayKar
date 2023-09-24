package com.PayKar.transaction.repository;

import com.PayKar.transaction.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransitionRepository extends JpaRepository<Transaction, UUID> {

}
