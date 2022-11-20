package com.example.teletrader.controllers;

import com.example.teletrader.dto.request.ProcessedOrderRequest;
import com.example.teletrader.services.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ApiOperation(value = "Saving of the order.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The order is saved successfully.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "500", description = "Server error.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    })
    public void saveOrder(@RequestBody ProcessedOrderRequest order) {
        orderService.saveOrder(order);
    }
}
