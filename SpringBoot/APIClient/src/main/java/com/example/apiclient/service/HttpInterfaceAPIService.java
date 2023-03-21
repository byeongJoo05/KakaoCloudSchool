package com.example.apiclient.service;

import org.springframework.web.service.annotation.GetExchange;

public interface HttpInterfaceAPIService {

	@GetExchange("/api/v1/crud-api")
	public String getName();
}
