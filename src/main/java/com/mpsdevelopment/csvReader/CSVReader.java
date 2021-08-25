package com.mpsdevelopment.csvReader;

import com.mpsdevelopment.entity.CoinStats;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class CSVReader {

    @Value("${csv.path}")
    private String csvPath;

    public List<CoinStats> getCoins() throws IOException {
        return new CsvToBeanBuilder<CoinStats>(new FileReader(csvPath))
                .withType(CoinStats.class)
                .withSkipLines(2)
                .build()
                .parse();
    }
}
