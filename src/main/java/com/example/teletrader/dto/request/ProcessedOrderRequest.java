package com.example.teletrader.dto.request;

import com.example.teletrader.enums.OperationType;
import com.example.teletrader.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessedOrderRequest {
    private Double price;
    private String ticker;
    private Long amount;
    private OrderType orderType;
    private OperationType operationType;
    private Long userId;
}
