package com.alex.rmb;

import org.apache.dubbo.config.ConsumerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude = MongoAutoConfiguration. class )
public class RmbApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmbApplication.class);
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setCheck(false);
		consumerConfig.setTimeout(20000);
		return consumerConfig;
	}
}
