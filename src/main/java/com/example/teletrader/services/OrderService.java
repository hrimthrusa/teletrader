package com.example.teletrader.services;

import com.example.teletrader.dto.request.OrderRequest;

public interface OrderService {
    void saveMarketOrder(OrderRequest orderRequest);
}
