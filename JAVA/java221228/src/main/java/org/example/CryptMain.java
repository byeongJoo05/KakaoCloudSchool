package org.example;

import org.mindrot.jbcrypt.BCrypt;

public class CryptMain {
    public static void main(String[] args) {
        // 복호화가 불가능한 암호화
        // 64 자리나 128자리 정도
        String encryptString = BCrypt.hashpw("123456789012345", BCrypt.gensalt());
        System.out.println(encryptString);

        // 비교 - 평문이 먼저오고 암호화된 문장. 순서가 바뀌면 안됨.
        System.out.println(BCrypt.checkpw("123456789012345", encryptString));
    }
}
