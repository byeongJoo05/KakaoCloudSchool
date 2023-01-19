package com.kakao.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTests {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void testEncode() {
        String password = "1111";
        String enPw = passwordEncoder.encode(password);
        System.out.println("enPw:" + enPw);
        // 다시 encode를 시키면 새로운 해싱된 비밀번호가 enPw 변수에 대입되게 됨.
        enPw = passwordEncoder.encode(password);
        System.out.println("enPw:" + enPw);

        // 해싱된 비밀번호와 진짜 비밀번호를 비교해서 매칭시킴.
        boolean result = passwordEncoder.matches(password, enPw);
        System.out.println("result = " + result);
    }
}
