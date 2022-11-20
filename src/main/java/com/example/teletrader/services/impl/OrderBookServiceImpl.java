package com.example.teletrader.services.impl;

import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.repositories.ProcessOrderRepository;
import com.example.teletrader.services.OrderBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderBookServiceImpl implements OrderBookService {
    private final ProcessOrderRepository processOrderRepository;

    @Override
    public List<ProcessedOrder> getTopTenBuyOrders() {
        return processOrderRepository.findTopTenBuyOrders();
    }

    @Override
    public List<ProcessedOrder> getTopTenSellOrders() {
        return processOrderRepository.findTopTenSellOrders();
    }
}
