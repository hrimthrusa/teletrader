package com.example.teletrader.repositories;

import com.example.teletrader.dto.request.OrderBookRequest;
import com.example.teletrader.models.ProcessedOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessOrderRepository extends JpaRepository<ProcessedOrder, Long> {

    @Query(value = "SELECT * FROM processed_orders WHERE (operation_type = 'BUY' AND ticker = :ticker) ORDER BY momentary_price DESC LIMIT 10"
            , nativeQuery = true)
    List<ProcessedOrder> findTopTenBuyOrders(@Param("ticker") String tickerName);

    @Query(value = "SELECT * FROM processed_orders WHERE (operation_type = 'SELL' AND ticker = :ticker  ) ORDER BY momentary_price LIMIT 10"
            , nativeQuery = true)
    List<ProcessedOrder> findTopTenSellOrders(@Param("ticker") String tickerName);
}
