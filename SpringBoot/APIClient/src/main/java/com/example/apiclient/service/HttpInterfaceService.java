package com.example.apiclient.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HttpInterfaceService {
	private final HttpInterfaceAPIService httpInterfaceAPIService;

	public String getName() {
		return httpInterfaceAPIService.getName();
	}
}
