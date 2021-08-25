package com.mpsdevelopment;

import com.mpsdevelopment.Repository.CoinRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CoinRepository.class)
public class CryptoEngineerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoEngineerApplication.class, args);
	}

}
