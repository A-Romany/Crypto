package com.mpsdevelopment.controller;

import com.mpsdevelopment.entity.CoinStats;
import com.mpsdevelopment.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CoinController {
    private CoinService coinService;

    @Autowired
    public CoinController(CoinService coinService) {
        this.coinService = coinService;
    }

    @PostMapping ("/consume-csv")
    public void addCoins() throws IOException {
        coinService.addCoins();
    }

    @GetMapping("/page")
    public Page<CoinStats> getCoinsPage(Pageable pageable) {
        return coinService.getCoinsPage(pageable);
    }

    @GetMapping("/monthStat")
    public CoinStats getMonthStat(int month, int year) {
        return coinService.getStatistics(month, year);
    }
}
