package com.example.teletrader.services;

import com.example.teletrader.models.ProcessedOrder;

import java.util.List;

public interface OrderBookService {
    List<ProcessedOrder> getTopTenBuyOrders();

    List<ProcessedOrder> getTopTenSellOrders();


}
