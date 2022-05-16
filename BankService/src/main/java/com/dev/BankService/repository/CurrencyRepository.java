package com.dev.BankService.repository;

import com.dev.BankService.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    List<Currency> findByCustomerId(UUID uuid);
}
