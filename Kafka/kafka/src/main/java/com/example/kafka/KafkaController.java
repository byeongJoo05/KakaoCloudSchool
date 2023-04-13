package com.example.kafka;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/kafka")
@Slf4j
@RequiredArgsConstructor
public class KafkaController {

	private final KafkaProducer kafkaProducer;

	@PostMapping
	@ResponseBody
	public String sendMessage(@RequestParam String message) {
		kafkaProducer.sendMessage(message);
		return "success";
	}
}
