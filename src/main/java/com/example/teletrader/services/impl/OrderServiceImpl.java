package com.example.teletrader.services.impl;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.enums.OrderType;
import com.example.teletrader.exceptions.ObjectNotFoundException;
import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.models.Stock;
import com.example.teletrader.models.User;
import com.example.teletrader.repositories.OrderLimitRepository;
import com.example.teletrader.repositories.ProcessOrderRepository;
import com.example.teletrader.repositories.StockRepository;
import com.example.teletrader.repositories.UserRepository;
import com.example.teletrader.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProcessOrderRepository processOrderRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;
    private final OrderLimitRepository orderLimitRepository;

    @Override
    public void saveOrder(ProcessedOrderRequest processedOrderRequest) {
        OrderType orderType = processedOrderRequest.getOrderType();

        switch (orderType) {
            case MARKET:
                saveMarketOrder(processedOrderRequest);
                break;
            case LIMIT:
                saveLimitOrder(processedOrderRequest);
                break;
        }
    }

    private void saveMarketOrder(ProcessedOrderRequest processedOrderRequest) {
        User user = userRepository.findById(processedOrderRequest.getUserId())
                .orElseThrow(() -> new ObjectNotFoundException("There is no such user available."));

        Stock stock = stockRepository.findByTicker(processedOrderRequest.getTicker())
                .orElseThrow(() -> new ObjectNotFoundException("There is no such ticker available."));

        ProcessedOrder processedOrder = ProcessedOrder.builder()
                .ticker(processedOrderRequest.getTicker())
                .amount(processedOrderRequest.getAmount())
                .momentaryPrice(stock.getPrice())
                .operationType(processedOrderRequest.getOperationType())
                .orderType(processedOrderRequest.getOrderType())
                .user(user)
                .build();

        processOrderRepository.save(processedOrder);
    }

    private void saveLimitOrder(ProcessedOrderRequest processedOrderRequest) {
        orderLimitRepository.saveLimitOrder(processedOrderRequest);
    }
}
