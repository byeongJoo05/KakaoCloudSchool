package com.example.springredis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springredis.service.MemberRedisService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RedisController {

	private final MemberRedisService memberRedisService;

	@PostMapping("/")
	public ResponseEntity<String> add() {
		memberRedisService.addMember();
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
}
