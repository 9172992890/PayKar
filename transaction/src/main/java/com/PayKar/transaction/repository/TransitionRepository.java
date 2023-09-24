package com.PayKar.transaction.repository;

import com.PayKar.transaction.Entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransitionRepository extends CrudRepository<Transaction, UUID> {

}
