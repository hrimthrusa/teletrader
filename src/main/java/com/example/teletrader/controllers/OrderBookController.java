package com.example.teletrader.controllers;

import com.example.teletrader.dto.request.OrderBookRequest;
import com.example.teletrader.models.ProcessedOrder;
import com.example.teletrader.services.OrderBookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-book")
@RequiredArgsConstructor
public class OrderBookController {
    private final OrderBookService orderBookService;

    @PostMapping("/buy")
    @ApiOperation(value = "Top 10 buy orders.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Top 10 is returned successfully.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Server error.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public List<ProcessedOrder> topTenBuyOrders(@RequestBody OrderBookRequest orderBookRequest) {
        return orderBookService.getTopTenBuyOrders(orderBookRequest);
    }

    @PostMapping("/sell")
    @ApiOperation(value = "Top 10 sell orders.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Top 10 is returned successfully.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Server error.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public List<ProcessedOrder> topTenSellOrders(@RequestBody OrderBookRequest orderBookRequest) {
        return orderBookService.getTopTenSellOrders(orderBookRequest);
    }
}
