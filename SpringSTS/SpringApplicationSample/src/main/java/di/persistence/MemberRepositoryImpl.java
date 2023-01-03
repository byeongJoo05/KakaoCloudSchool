package di.persistence;

import di.entity.MemberEntity;

public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public MemberEntity findById(String id) {
		// new Member("adam", "1234", "군계")
		MemberEntity memberEntity = MemberEntity.builder()
				.id("adam")
				.password("1234")
				.nickname("군계")
				.build();
		
		return memberEntity;
	}

}
