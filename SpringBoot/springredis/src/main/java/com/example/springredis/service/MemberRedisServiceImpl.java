package com.example.springredis.service;

import org.springframework.stereotype.Service;

import com.example.springredis.domain.Member;
import com.example.springredis.repository.MemberRedisRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberRedisServiceImpl implements MemberRedisService {
	private final MemberRedisRepository memberRedisRepository;

	// 데이터를 삽입의 리턴 타입 : DTO(정보를 리턴 - 드문 케이스)
	// 기본키(성공과 실패 여부와 어떤 데이터가 추가되었는지 확인)
	// void(모든 예외에 대한 처리 코드가 작성되서 서버에 구성이 되어 있어 실패할 가능성이 없는 경우)
	@Override
	public void addMember() {
		Member member = new Member("아담", 45);
		memberRedisRepository.save(member);
	}
}
