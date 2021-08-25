package com.mpsdevelopment.entity;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class CoinStats {

    @javax.persistence.Id
    @Id
    @Column
    @CsvBindByPosition(position = 0)
    private Long unix;

    @CsvDate(value = "yyyy-MM-dd H:mm:ss")
    @CsvBindByPosition(position = 1)
    @Column
    private LocalDateTime date;

    @CsvBindByPosition(position = 2)
    @Column
    private String symbol;

    @CsvBindByPosition(position = 3)
    @Column
    private Double open;

    @CsvBindByPosition(position = 4)
    @Column
    private Double high;

    @CsvBindByPosition(position = 5)
    @Column
    private Double low;

    @CsvBindByPosition(position = 6)
    @Column
    private Double close;

    @CsvBindByPosition(position = 7)
    @Column
    private Double volumeADA;

    @CsvBindByPosition(position = 8)
    @Column
    private Double volumeUSDT;

    @CsvBindByPosition(position = 9)
    @Column
    private Integer tradeCount;

    public void setUnix(Long unix) {
        this.unix = unix;
    }

    public Long getUnix() {
        return unix;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getSymbol() {
        return symbol;
    }

    public Double getOpen() {
        return open;
    }

    public Double getHigh() {
        return high;
    }

    public Double getLow() {
        return low;
    }

    public Double getClose() {
        return close;
    }

    public Double getVolumeADA() {
        return volumeADA;
    }

    public Double getVolumeUSDT() {
        return volumeUSDT;
    }

    public Integer getTradeCount() {
        return tradeCount;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setOpen(Double open) {
        this.open = open;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public void setClose(Double close) {
        this.close = close;
    }

    public void setVolumeADA(Double volumeADA) {
        this.volumeADA = volumeADA;
    }

    public void setVolumeUSDT(Double volumeUSDT) {
        this.volumeUSDT = volumeUSDT;
    }

    public void setTradeCount(Integer tradeCount) {
        this.tradeCount = tradeCount;
    }

    @Override
    public String toString() {
        return "CoinStats{" +
                "unix='" + unix + '\'' +
                ", date='" + date + '\'' +
                ", symbol='" + symbol + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volumeADA=" + volumeADA +
                ", volumeUSDT=" + volumeUSDT +
                ", tradeCount=" + tradeCount +
                '}';
    }
}

