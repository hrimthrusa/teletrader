package com.example.teletrader.services.impl;

import com.example.teletrader.dto.request.OrderBookRequest;
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
    public List<ProcessedOrder> getTopTenBuyOrders(OrderBookRequest orderBookRequest) {
        return processOrderRepository.findTopTenBuyOrders(orderBookRequest.getTicker());
    }

    @Override
    public List<ProcessedOrder> getTopTenSellOrders(OrderBookRequest orderBookRequest) {
        return processOrderRepository.findTopTenSellOrders(orderBookRequest.getTicker());
    }
}
