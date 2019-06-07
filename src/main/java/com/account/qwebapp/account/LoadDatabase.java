package com.account.qwebapp.account;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class LoadDatabase {

	private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);
	
	
	@Bean
	CommandLineRunner initDatabaseApr(AccountProfileRepository repository) {
		return args -> {
			logger.info("Preloading " + repository.save(new AccountProfile("John", "red", "smith")));
			logger.info("Preloading " + repository.save(new AccountProfile("Allen", "", "Greenwood")));
		};
	}
	
	@Bean
	CommandLineRunner initDatabase(AccountRepository repository) {
		return args -> {
			logger.info("Preloading " + repository.save(new Account("STAFF", "Arnold", true, new Long(1), "arnie11", new BigDecimal(635427.88), "CAD")));
			logger.info("Preloading " + repository.save(new Account("SAV", "Henry", true, new Long(2), "arrow22", new BigDecimal(348767.76), "USD")));
		};
	}
	

}
