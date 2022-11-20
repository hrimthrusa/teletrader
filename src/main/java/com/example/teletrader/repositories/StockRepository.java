package com.example.teletrader.repositories;

import com.example.teletrader.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE stocks SET price = random() * (100-50) + 50 WHERE id <> 0",
    nativeQuery = true)
    void changePrice();

    Optional<Stock> findByTicker(String ticker);
}
