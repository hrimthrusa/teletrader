package com.example.teletrader.services.impl;

import com.example.teletrader.dto.request.OrderRequest;
import com.example.teletrader.enums.OrderType;
import com.example.teletrader.models.Order;
import com.example.teletrader.repositories.OrderRepository;
import com.example.teletrader.services.OrderService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    @Override
    public void saveMarketOrder(OrderRequest orderRequest) {
        Order order = new Order();

        order.setPrice(orderRequest.getPrice());
        order.setAmount(orderRequest.getAmount());
        order.setOperationType(orderRequest.getOperationType());
        order.setOrderType(OrderType.MARKET);

        orderRepository.save(order);
    }
}
