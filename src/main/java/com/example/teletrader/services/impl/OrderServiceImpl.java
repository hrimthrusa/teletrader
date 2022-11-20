package com.example.teletrader.services.impl;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.enums.OrderType;
import com.example.teletrader.exceptions.ObjectNotFoundException;
import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.models.Stock;
import com.example.teletrader.models.User;
import com.example.teletrader.repositories.OrderRepository;
import com.example.teletrader.repositories.ProcessOrderRepository;
import com.example.teletrader.repositories.StockRepository;
import com.example.teletrader.repositories.UserRepository;
import com.example.teletrader.services.OrderService;
import lombok.RequiredArgsConstructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final ProcessOrderRepository processOrderRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;
    @Override
    public void saveOrder(ProcessedOrderRequest processedOrderRequest) {
        OrderType orderType = processedOrderRequest.getOrderType();

        switch (orderType) {
            case MARKET :
                saveMarketOrder(processedOrderRequest);
                break;
            case LIMIT :
                saveLimitOrder(processedOrderRequest);
                break;
        }
//        Order order = new Order();
//
//        order.setPrice(orderRequest.getPrice());
//        order.setAmount(orderRequest.getAmount());
//        order.setOperationType(orderRequest.getOperationType());
//        order.setOrderType(OrderType.MARKET);
//
//        orderRepository.save(order);
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
        User user = userRepository.findById(processedOrderRequest.getUserId())
                .orElseThrow(() -> new ObjectNotFoundException("There is no such user available."));

        boolean orderIsExecuted = false;
        while (!orderIsExecuted) {
            Stock stock = stockRepository.findByTicker(processedOrderRequest.getTicker())
                    .orElseThrow(() -> new ObjectNotFoundException("There is no such ticker available."));

            double momentaryStockPrice = stock.getPrice();
            double desiredPurchasePrice = processedOrderRequest.getPrice();
            System.out.println(momentaryStockPrice);

            if (momentaryStockPrice > 0 && momentaryStockPrice <= desiredPurchasePrice) {
                ProcessedOrder processedOrder = ProcessedOrder.builder()
                        .ticker(processedOrderRequest.getTicker())
                        .amount(processedOrderRequest.getAmount())
                        .momentaryPrice(stock.getPrice())
                        .operationType(processedOrderRequest.getOperationType())
                        .orderType(processedOrderRequest.getOrderType())
                        .user(user)
                        .build();

                processOrderRepository.save(processedOrder);
                orderIsExecuted = true;
                System.out.println(momentaryStockPrice + " operaciya vipolnena");

            }
            try {
                Thread.sleep(5020);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
