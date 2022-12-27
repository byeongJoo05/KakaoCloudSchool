package stream;

import java.util.Arrays;

public class Comparator {
    public static void main(String[] args) {
        // 데이터 정렬을 위해서 문자열 배열 생성
        String[] ar = {"야구", "축구", "배구", "농구", "당구"};

        /*Arrays.sort(ar, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/

        // 코드는 간결해졌지만 가독성이 떨어짐.
        Arrays.sort(ar, (o1, o2) ->
            o2.compareTo(o1)
        );
        System.out.println(Arrays.toString(ar));
    }
}
