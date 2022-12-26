package network;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ReductionOperator {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "남자현", "안중근", "안창호", "유관순",
                "이순신", "홍범도", "윤봉길", "홍범도"
        );
        // 스트림 생성
        Stream <String> stream = list.stream();
        // 전체출력
        // stream.forEach((temp) -> System.out.print(temp + "\t"));

        // 2개 빼고 출력
        // stream.skip(2).forEach((temp) -> System.out.print(temp + "\t"));

        // 2개 건너뛰고 3개 사용
//        stream.skip(2).limit(3).forEach((temp) -> System.out.print(temp + "\t"));

        // 중복 제거 - 홍범도가 1번만 출력됨
//        stream.distinct().forEach((temp) -> System.out.print(temp + "\t"));

        // 필터링
        // 매개변수가 1개이고 Boolean을 리턴하는 함수를 대입
        /*stream.filter(
                name -> name.charAt(0) == '안'
        ).forEach((temp) -> System.out.print(temp + "\t"));*/

        // ㅇ으로 시작하는
        // sort()는 필터링 후 사용하는 것이 효율적임. -> sort()를 먼저할 경우 전체 데이터를 정렬하기에 시간복잡도가 늘어남.
        stream.filter(
                name -> name.charAt(0) >= '아' && name.charAt(0) <'자'
        ).sorted().forEach((temp) -> System.out.print(temp + "\t"));
    }
}
