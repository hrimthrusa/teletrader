package com.example.teletrader.controllers;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void saveOrder(@RequestBody ProcessedOrderRequest order) {
        orderService.saveOrder(order);
    }
}
