package com.example.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
	// 토픽 이름 설정 - 고유해야 함
	private static final String TOPIC = "adam-topic";

	private final KafkaTemplate<String, String> kafkaTemplate;

	// 메세지 전송
	public void sendMessage(String message) {
		log.info("생성한 메시지:" + message);
		kafkaTemplate.send(TOPIC, message);
	}
}
