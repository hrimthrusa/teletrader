package com.example.teletrader.services;

import com.example.teletrader.dto.request.OrderBookRequest;
import com.example.teletrader.models.ProcessedOrder;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderBookService {
    List<ProcessedOrder> getTopTenBuyOrders(OrderBookRequest orderBookRequest);

    List<ProcessedOrder> getTopTenSellOrders(OrderBookRequest orderBookRequest);


}
