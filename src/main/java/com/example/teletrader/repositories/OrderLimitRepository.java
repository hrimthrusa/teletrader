package com.example.teletrader.repositories;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.exceptions.ObjectNotFoundException;
import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.models.Stock;
import com.example.teletrader.models.User;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@RequiredArgsConstructor
@Component
public class OrderLimitRepository {

    private final SessionFactory sessionfactory;

    private final ProcessOrderRepository processOrderRepository;
    private final StockRepository stockRepository;
    private final UserRepository userRepository;
    private final EntityManagerFactory entityManagerFactory;


    public void saveLimitOrder(ProcessedOrderRequest processedOrderRequest) {
    User user = userRepository.findById(processedOrderRequest.getUserId())
            .orElseThrow(() -> new ObjectNotFoundException("There is no such user available."));

        Session session = entityManagerFactory.unwrap(Session.class);
        boolean orderIsExecuted = false;
        while (!orderIsExecuted) {
            Query query = session.createQuery("from Stock where ticker = :paramName");
            query.setParameter("paramName", processedOrderRequest.getTicker());
            Stock stock = (Stock) query.getSingleResult();
//        Stock stock = stockRepository.findByTicker(processedOrderRequest.getTicker())
//                .orElseThrow(() -> new ObjectNotFoundException("There is no such ticker available."));

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
        session.clear();
    }
}
}
