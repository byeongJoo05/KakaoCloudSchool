package com.example.apiclient.service;

import org.apache.hc.core5.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class WebClientService {
	// 매개변수 없고 String을 리턴
	public String getName() {
		WebClient webClient = WebClient.builder()
			.baseUrl("http://localhost:9000")
			.defaultHeader(HttpHeaders.CONTENT_TYPE,
				MediaType.APPLICATION_JSON_VALUE)
			.build();
		// 동기식 동작
		return webClient.get()
			.uri("/api/v1/crud-api")
			.retrieve()
			.bodyToMono(String.class)
			.block();
	}

	// PathVariable 이 있는 경우
	public String getNameWithPathVariable() {
		WebClient webClient = WebClient.create("http://localhost:9000");


		/*
		// 아래와 동작은 같다.

		webClient.get()
			.uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api/{name}")
				.build("adam"))
			.retrieve()
			.bodyToMono(String.class)
			.block();
		*/

		ResponseEntity<String> responseEntity = webClient.get()
			.uri("/api/v1/crud-api/{name}", "adam")
			.retrieve()
			.toEntity(String.class)
			.block();

		return responseEntity.getBody();
	}

	public String getNameWithParameter() {
		WebClient webClient = WebClient.create("http://localhost:9000");
		return webClient.get().uri(uriBuilder -> uriBuilder.path("/api/v1/crud-api")
			.queryParam("name", "adam")
			.build())
			.exchangeToMono(clientResponse -> {
				if (clientResponse.statusCode().equals(HttpStatus.OK)) {
					return clientResponse.bodyToMono(String.class);
				} else {
					return clientResponse.createException().flatMap(Mono::error);
				}
			})
			.block();
	}
}
