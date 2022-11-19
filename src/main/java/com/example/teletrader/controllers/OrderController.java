package com.example.teletrader.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @PostMapping("/market")
    public void postOrderMarket() {

    }

    @PostMapping("/limit")
    public void postOrderLimit() {

    }

    @PostMapping("/stop")
    public void postOrderStop() {

    }

    @PostMapping("/stop-limit")
    public void postOrderStopLimit() {

    }

    @PostMapping("/trailing-stop")
    public void postOrderTrailingStop() {

    }
}
