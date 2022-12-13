package operator;

public class ShiftOperator {
    public static void main(String[] args) {
        int x = -29;
        System.out.println(x << 2); // 1번 밀 때 마다 2 곱하기
        System.out.println(x >> 3); // 1번 밀 때 마다 3 곱하기
        System.out.println(x >>> 3); // 부호 변경
        System.out.println(x << 32); // 32번 밀었기에 원래 데이터와 같은 결과
    }
}
