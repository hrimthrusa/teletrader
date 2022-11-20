package com.example.teletrader.models;

import com.example.teletrader.enums.OperationType;
import com.example.teletrader.enums.OrderType;
import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "processed_orders")
@ApiModel(description = "The details about the processed order.")
@Getter
@Setter
@Builder
public class ProcessedOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "ticker")
    private String ticker;
    @Column(name = "amount")
    private Long amount;
    @Column(name = "momentary_price")
    private Double momentaryPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type")
    private OperationType operationType;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_type")
    private OrderType orderType;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
