package com.example.teletrader.repositories;

import com.example.teletrader.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {
    @Query("UPDATE Stock s SET s.price = random() * (100-50) + 50 WHERE s.id <> 0")
    void changePrice();
}
