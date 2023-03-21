package com.example.apiclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiclient.service.HttpInterfaceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/httpinterface")
public class HttpInterfaceController {

	private final HttpInterfaceService httpInterfaceService;

	@GetMapping
	public String getName() {
		return httpInterfaceService.getName();
	}

}
