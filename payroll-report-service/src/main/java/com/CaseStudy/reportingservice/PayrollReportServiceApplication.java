package com.CaseStudy.reportingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PayrollReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollReportServiceApplication.class, args);
	}

}
