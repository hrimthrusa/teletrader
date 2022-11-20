package com.example.teletrader.services;

import com.example.teletrader.dto.request.ProcessedOrderRequest;

public interface OrderService {
    void saveOrder(ProcessedOrderRequest processedOrderRequest);
}
