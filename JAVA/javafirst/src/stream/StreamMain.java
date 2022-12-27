package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {
        // Student 클래스의 List 생성
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "김좌진", "남자", "컴공", 93));
        list.add(new Student(2, "안중근", "남자", "기계", 100));
        list.add(new Student(3, "윤봉길", "남자", "사체", 83));
        list.add(new Student(4, "유관순", "여자", "컴공", 99));
        list.add(new Student(5, "남자현", "여자", "컴공", 87));

        // score의 합계
        // Student를 Student.getScore 메서드의 결과를 이용해서
        // 정수로 변환
        int sum = list.stream().mapToInt(Student::getScore).sum();
        System.out.println("점수의 합계 : " + sum);

        // 평균 구하기
        OptionalDouble avg = list.stream().mapToInt(Student::getScore).average();

        // Optional이 붙는 자료형은 null 여부를 확인 후 사용
        if (avg.isPresent() == true) {
            System.out.println("평균 : " + avg.getAsDouble());
        } else {
            System.out.println("평균을 구할 수 없음");
        }

        // reduce - 집계
        // 매개변수가 2개이고 리턴이 있는 메서드를 제공
        // 처음 2개의 데이터를 가지고 메서드를 호출해서 결과를 만들고
        // 그 다음부터는 결과 다음 데이터를 가지고 메서드를 호출
        sum = list.stream().mapToInt(Student::getScore).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum);

        // 남자만 추출해서 List로 변환
        List<Student> manList = list.stream().filter(student -> student.getGender().equals("남자"))
                .collect(Collectors.toList());
        System.out.println(manList);

        // gender 별로 그룹화해서 score의 평균 구하기
        Map<String, Double> genderMap = list.stream().collect(Collectors.groupingBy(
                Student::getGender, Collectors.averagingDouble(Student::getScore)));
//        System.out.println(genderMap); // 남자, 여자 전체 출력
        System.out.println(genderMap.get("남자")); // 남자만 출력
    }
}
