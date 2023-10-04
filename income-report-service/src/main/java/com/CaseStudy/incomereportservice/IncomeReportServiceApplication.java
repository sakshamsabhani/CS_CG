package com.CaseStudy.incomereportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IncomeReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomeReportServiceApplication.class, args);
	}

}
