package com.dev.BankService.repository;

import com.dev.BankService.model.AllowedCurrencies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllowedCurrenciesRepository extends JpaRepository<AllowedCurrencies,Integer> {
    AllowedCurrencies findByName(String name);
}
