package com.alex.dollar;

import org.apache.dubbo.config.ConsumerConfig;
import org.dromara.hmily.spring.annotation.RefererAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication (exclude = MongoAutoConfiguration. class )
public class DollarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DollarApplication.class,args);
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig consumerConfig = new ConsumerConfig();
		consumerConfig.setCheck(false);
		consumerConfig.setTimeout(20000);
		return consumerConfig;
	}

	@Bean
	public BeanPostProcessor refererAnnotationBeanPostProcessor() {
		return new RefererAnnotationBeanPostProcessor();
	}
}
