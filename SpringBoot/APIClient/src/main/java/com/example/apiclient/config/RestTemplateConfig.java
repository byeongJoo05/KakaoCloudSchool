package com.example.apiclient.config;

import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.example.apiclient.interceptor.IdentityHeaderInterceptor;

@Configuration
public class RestTemplateConfig {
	// 팩토리 클래스의 bean 설정
	@Bean
	public ClientHttpRequestFactory clientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

		// 대기 시간과 읽는 시간 최대값 설정
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(2000);
		factory.setBufferRequestBody(false);

		return factory;
	}

	// RestTemplate 빈 설정
	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

		restTemplate.getInterceptors().add(new IdentityHeaderInterceptor());
		restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
		return restTemplate;
	}
}
