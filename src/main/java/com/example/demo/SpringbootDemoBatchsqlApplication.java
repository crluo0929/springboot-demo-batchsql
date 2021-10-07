package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo")
@EntityScan(basePackages = "com.example.demo")
@EnableTransactionManagement
public class SpringbootDemoBatchsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoBatchsqlApplication.class, args);
	}

}
