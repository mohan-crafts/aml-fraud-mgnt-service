package com.txn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FraudMgntServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FraudMgntServiceApplication.class, args);
	}

}
	