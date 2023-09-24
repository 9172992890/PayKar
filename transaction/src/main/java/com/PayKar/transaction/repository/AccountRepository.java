package com.PayKar.transaction.repository;

import com.PayKar.transaction.Entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountInfo, UUID> {
}