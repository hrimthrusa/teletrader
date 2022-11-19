package com.example.teletrader.dto.request;

import com.example.teletrader.enums.OperationType;
import com.example.teletrader.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Double price;
    private Long amount;
    private OperationType operationType;
}
