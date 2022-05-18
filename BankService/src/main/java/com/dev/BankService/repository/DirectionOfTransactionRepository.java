package com.dev.BankService.repository;

import com.dev.BankService.model.DirectionOfTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectionOfTransactionRepository extends JpaRepository<DirectionOfTransaction,Integer> {
    DirectionOfTransaction findByDirection(String str);
}
