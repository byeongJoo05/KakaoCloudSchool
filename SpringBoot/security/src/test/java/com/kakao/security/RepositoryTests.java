package com.kakao.security;

import com.kakao.security.model.ClubMember;
import com.kakao.security.model.ClubMemberRole;
import com.kakao.security.persistence.ClubMemberRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class RepositoryTests {
    @Autowired
    private ClubMemberRepository clubMemberRepository;

    /*
    우리가 주입을 받을 때, @Autowired로 하는 방식과 @RequiredArgsConstructor + final 방식이 있다.
    테스트할 때는 @Autowired를 하고 있는데, 그 이유가 @RequiredArgsConstructor를 사용하게 되면
    final 명령예약어가 사용되고 있는 변수를 생성자 주입으로 사용하게 된다.
    근데 테스트 코드를 작성하는 공간은 우리가 흔히 사용하는 스프링 컨테이너 공간이 아닌 JUnit5 이기에
    의존성 주입의 타입이 정해져 있어 @Autowired 만 가능한 것이다.
    JUnit5 는 스스로 DI를 지원한다. DI를 지원하는 타입은 정해져 있다. JUnit5에서 생성자나 lombok 방식으로 DI가 안되는 이유는
    JUnit이 생성자에 의존성을 주입하려고 먼저 개입하기 때문이다.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertMembers() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            ClubMember clubMember = ClubMember.builder()
                    .mid("member"+i)
                    .mpw(passwordEncoder.encode("1111"))
                    .email("user"+i+"@gmail.com")
                    .name("사용자"+i)
                    .social(false)
                    .roleSet(new HashSet<ClubMemberRole>())
                    .build();
            clubMember.addRole(ClubMemberRole.USER);
            if (i > 90) {
                clubMember.addRole(ClubMemberRole.ADMIN);
            }
            clubMemberRepository.save(clubMember);
        });
    }

    // mid를 이용해서 조회하는 메서드
    @Test
    public void testRead() {
        Optional<ClubMember> result = clubMemberRepository.getWithRoles("member100");
        if (result.isPresent()) { //result의 값이 존재한다면
            System.out.println("result = " + result);
            System.out.println("result 의 권한 확인 = " + result.get().getRoleSet());
        } else {
            System.out.println("존재하지 않는 아이디");
        }

    }

    @Test
    public void testReadEmail() {
        Optional<ClubMember> clubMember = clubMemberRepository.findByEmail("user95@gmail.com");
        System.out.println(clubMember.get().getRoleSet());
    }
}
