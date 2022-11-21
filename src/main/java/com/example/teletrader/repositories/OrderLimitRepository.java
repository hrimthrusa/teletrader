package com.example.teletrader.repositories;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.enums.OperationType;
import com.example.teletrader.exceptions.ObjectNotFoundException;
import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.models.Stock;
import com.example.teletrader.models.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@RequiredArgsConstructor
@Component
public class OrderLimitRepository {
    private final ProcessOrderRepository processOrderRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;


    public void saveLimitOrder(ProcessedOrderRequest processedOrderRequest) {
        User user = userRepository.findById(processedOrderRequest.getUserId())
                .orElseThrow(() -> new ObjectNotFoundException("There is no such user available."));

        Session session = entityManager.unwrap(Session.class);
        boolean orderIsExecuted = false;

        while (!orderIsExecuted) {
            Query query = session.createQuery("FROM Stock WHERE ticker = :paramName");
            query.setParameter("paramName", processedOrderRequest.getTicker());
            Stock stock = (Stock) query.getSingleResult();

            double momentaryStockPrice = stock.getPrice();
            double desiredOperationPrice = processedOrderRequest.getPrice();

            if (processedOrderRequest.getOperationType() == OperationType.BUY) {
                if (momentaryStockPrice > 0 && momentaryStockPrice <= desiredOperationPrice) {
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
                    System.out.println("The limit order executed successfully. Price: " + momentaryStockPrice);
                }
            } else if (processedOrderRequest.getOperationType() == OperationType.SELL) {
                if (momentaryStockPrice >= desiredOperationPrice) {
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
                    System.out.println("The limit order executed successfully. Price: " + momentaryStockPrice);
                }
                try {
                    Thread.sleep(5020);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                session.clear();
            }
        }
    }
}
