package utilPrac;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 정수 배열
        int[] ar = {60, 30, 20, 87, 56};

        // 문자열 배열
        String [] br = {
                "호날두", "메시", "음바페", "네이마르", "베인"
        };

        // 배열의 데이터 확인
        System.out.println(Arrays.toString(ar));

        // 정수 배열 정렬
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));

        // 문자열 배열 정렬
        Arrays.sort(br);
        System.out.println(Arrays.toString(br));

        // VO 클래스의 인스턴스 5개를 소유하는 배열
        VO[] datas = new VO[5];
        datas[0] = new VO(1, "배수지", 28);
        datas[1] = new VO(2, "이지은", 29);
        datas[2] = new VO(3, "배주현", 31);
        datas[3] = new VO(4, "박수영", 27);
        datas[4] = new VO(5, "룰루랄라", 23);
        System.out.println(Arrays.toString(datas));

        Arrays.sort(datas);
        System.out.println(Arrays.toString(datas));
    }
}
