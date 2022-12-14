package com.example.teletrader.models;

import com.example.teletrader.enums.OperationType;
import com.example.teletrader.enums.OrderType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@ApiModel(description = "The details about the order.")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "price")
    private Double price;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;
}
