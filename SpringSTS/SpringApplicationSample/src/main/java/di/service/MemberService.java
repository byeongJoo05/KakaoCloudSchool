package di.service;

import di.dto.MemberDTO;

public interface MemberService {
	// 기본키 1개를 받아서 하나의 데이터를 리턴하는 메서드
	// 매개변수나 리턴 타입에 Entity Type을 사용하면 안됨.
	public MemberDTO findById(String id);
}
