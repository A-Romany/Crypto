package com.mpsdevelopment.Repository;

import com.mpsdevelopment.entity.CoinStats;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CoinRepository extends MongoRepository<CoinStats, Long> {

    Page<CoinStats> findAll(Pageable pageable);

    List<CoinStats> findByDateBetween(LocalDateTime localDateStart, LocalDateTime localDateEnd);

}
