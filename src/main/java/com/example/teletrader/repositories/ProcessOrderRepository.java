package com.example.teletrader.repositories;

import com.example.teletrader.models.ProcessedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessOrderRepository extends JpaRepository<ProcessedOrder, Long> {
}
