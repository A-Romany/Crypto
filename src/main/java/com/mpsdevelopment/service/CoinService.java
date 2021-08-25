package com.mpsdevelopment.service;


import com.mpsdevelopment.Repository.CoinRepository;
import com.mpsdevelopment.csvReader.CSVReader;
import com.mpsdevelopment.entity.CoinStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CoinService {
    private final CoinRepository coinRepository;
    private final CSVReader csvReader;

    public CoinService(CoinRepository coinRepository, CSVReader csvReader) {
        this.coinRepository = coinRepository;
        this.csvReader = csvReader;
    }

    public void addCoins() throws IOException {
        coinRepository.saveAll(csvReader.getCoins());
    }

    public Page<CoinStats> getCoinsPage(Pageable pageable) {
        return coinRepository.findAll(pageable);
    }

    public CoinStats getStatistics(int month, int year) {
        LocalDateTime localDateStart = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime localDateEnd = localDateStart.plusMonths(1).plusDays(1);

        List<CoinStats> coinStats = coinRepository.findByDateBetween(localDateStart, localDateEnd);

        return createMonthStatCoin(month, year, coinStats);
    }

    private CoinStats createMonthStatCoin(int month, int year, List<CoinStats> coinStats) {
        CoinStats monthStats = new CoinStats();

        monthStats.setUnix(month * 10000L + year);
        monthStats.setDate(LocalDateTime.of(year, month, 1, 0, 0));
        monthStats.setSymbol(coinStats.get(coinStats.size() - 1).getSymbol());
        monthStats.setOpen(coinStats.get(coinStats.size() - 1).getOpen());
        monthStats.setHigh(getMonthHigh(coinStats));
        monthStats.setLow(getMonthLow(coinStats));
        monthStats.setClose(coinStats.get(0).getClose());
        monthStats.setVolumeADA(getMonthVolumeADA(coinStats));
        monthStats.setVolumeUSDT(getMonthVolumeUSDT(coinStats));
        monthStats.setTradeCount(getTradeCount(coinStats));

        return monthStats;
    }

    private Double getMonthHigh(List<CoinStats> coinStats) {
        return coinStats.
                stream()
                .max(Comparator.comparing(CoinStats::getHigh))
                .orElseThrow(NoSuchElementException::new)
                .getHigh();
    }

    private Double getMonthLow(List<CoinStats> coinStats) {
        return coinStats.
                stream()
                .min(Comparator.comparing(CoinStats::getLow))
                .orElseThrow(NoSuchElementException::new)
                .getLow();
    }

    private Double getMonthVolumeADA(List<CoinStats> coinStats) {
        return coinStats.
                stream()
                .mapToDouble(CoinStats::getVolumeADA)
                .sum();
    }

    private Double getMonthVolumeUSDT(List<CoinStats> coinStats) {
        return coinStats.
                stream()
                .mapToDouble(CoinStats::getVolumeUSDT)
                .sum();
    }

    private Integer getTradeCount(List<CoinStats> coinStats) {
        return coinStats.
                stream()
                .mapToInt(CoinStats::getTradeCount)
                .sum();
    }
}
