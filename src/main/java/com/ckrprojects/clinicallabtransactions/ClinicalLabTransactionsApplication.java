package com.ckrprojects.clinicallabtransactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "utcDateTimeProvider")
public class ClinicalLabTransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicalLabTransactionsApplication.class, args);
	}

}
