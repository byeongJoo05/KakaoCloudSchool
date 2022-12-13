package datatype;

public class PrimitiveType {

    public static void main(String[] args) {
        // 정수 저장하고 출력
        int x = 100;
        System.out.println("x = " + x);

        // 동일한 공간에서 동일한 이름의 변수를 2번 생성하면 에러
//        int x = y;
        int y = 100;
        // 실제 데이터의 참조 위치를 확인
        System.out.println("x = " + System.identityHashCode(x));
        System.out.println("y = " + System.identityHashCode(y));

        // 정수는 자신의 자료형 보다 큰 범위 데이터를 참조할 수 없음
//        x = 2000000000000;

        // 21억보다 크거나 -21억 보다 작은 정수는 long으로 생성
        long l = 20000000000L;
        System.out.println("l = " + l);

        // 16진수 저장
        x = 0x78A;
        System.out.println("x = " + x);
        // 8진수 저장 - 권한 설정할 때 임.
        // rwx로 권한을 표현하는 경우가 많음
        x = 0777;
        System.out.println("x = " + x);

        // 정밀도가 7번째 자리 까지 이므로 8번째 자리 아래에서 반올림
        float f = 0.1234567890123456789f;
        System.out.println("f = " + f);

        char ch = 'A';
        System.out.println("ch = " + ch);
        System.out.println("ch+1 = " + (ch+1));

//        ch = '\u0061'; // 아스키 코드 97을 의미함. (16진수 61)
        ch = '\uAC00'; // 한글 '가'
        System.out.println("ch = " + ch);

        // int는 21억 정도까지 저장 가능한데 연산의 결과가
        // 21억이 넘어섬 - Overflow
        // 이 경우는 결과가 음수가 됨
        // 음수와 음수를 더한 게 -21억을 넘으면 Underflow가 발생하게 됨.
        x = -2000000000 + -1000000000;
        System.out.println(x);
        
    }
}
