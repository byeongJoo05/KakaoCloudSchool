package com.example.kafka2;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	// 카프카 구독 메서드
	@KafkaListener(topics="adam-topic", groupId = "adamsoft")
	public void consume(String message) throws IOException {
		log.info("Consumed message: {}", message);
	}
}
