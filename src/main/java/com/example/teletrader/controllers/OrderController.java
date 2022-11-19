package com.example.teletrader.controllers;

import com.example.teletrader.dto.request.OrderRequest;
import com.example.teletrader.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/market")
    public void postOrderMarket(@RequestBody OrderRequest order) {
        orderService.saveMarketOrder(order);
    }

    @PostMapping("/limit")
    public void postOrderLimit() {

    }

    @PostMapping("/stop")
    public void postOrderStop() {

    }

    @PostMapping("/stop-limit")
    public void postOrderStopLimit() {

    }

    @PostMapping("/trailing-stop")
    public void postOrderTrailingStop() {

    }
}
