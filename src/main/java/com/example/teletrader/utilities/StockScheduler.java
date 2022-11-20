package com.example.teletrader.utilities;

import com.example.teletrader.repositories.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StockScheduler {
    private final StockRepository stockRepository;

    @Scheduled(initialDelay = 1000L, fixedDelay = 5000L)
    public void changePrice() {
        stockRepository.changePrice();
    }


}
