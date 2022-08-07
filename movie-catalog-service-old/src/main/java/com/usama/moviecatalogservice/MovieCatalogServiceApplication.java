package com.usama.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
//@EnableCircuitBreaker
public class MovieCatalogServiceApplication {


//	@Bean
//	public WebClient.Builder getWebClientBuilder(){
//		return WebClient.builder();
//	}
	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

//	@LoadBalanced
//	@Bean
//	public RestTemplate getRestTemplate(){
//		HttpComponentsClientHttpRequestFactory componentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//		componentsClientHttpRequestFactory.setConnectTimeout(3000);
//		return new RestTemplate();
//	}

}
