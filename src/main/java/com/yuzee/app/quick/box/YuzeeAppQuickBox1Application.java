package com.yuzee.app.quick.box;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;


@Configuration
@ComponentScan(basePackages = "com.yuzee")
@SpringBootApplication
@EnableDiscoveryClient
public class YuzeeAppQuickBox1Application {

	public static void main(String[] args) {
		SpringApplication.run(YuzeeAppQuickBox1Application.class, args);
	}
	
	   @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
