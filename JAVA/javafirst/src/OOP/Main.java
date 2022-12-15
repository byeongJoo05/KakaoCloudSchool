package OOP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
/*

        //Student 클래스의 인스턴스 생성
        Student student = new Student();
        // 자신의 속성에 접근
        student.num = 1;
        student.name = "아이린";
        student.kor = 32;
        student.eng = 19;
        student.mat = 40;

        Student student1 = new Student();
        student1.num = 2;
        student1.name = "누군가";
        student1.kor = 32;
        student1.eng = 19;
        student1.mat = 40;
        // 인스턴스 속성은 인스턴스 별로 별도로 소유
        System.out.println(student.num);
        System.out.println(student1.num);

        // 자바는 static 속성에 인스턴스가 접근 가능
        student.schoolName = "명덕고등학교";
        student1.schoolName = "제일중학교";
        // static 속성은 모든 인스턴스가 공유하므로
        // 동일한 데이터가 출력됨.
        System.out.println(student.schoolName);
        System.out.println(student1.schoolName);

*/

        MethodClass.noArgsMethod();
        MethodClass.onArgsMethod(5);
        MethodClass.twoArgsMethod(3,"hello");
        MethodClass obj = new MethodClass();
        // 리턴된 결과 가져오기
        int result = obj.addWithInteger(10, 30);
        System.out.println("result = " + result);
        // 리턴된 결과를 가지고 다른 작업을 수행할 수 있음.
        result = obj.addWithInteger(result, 90);
        System.out.println("결과:"+result);

        int x = 10;
        MethodClass.callByValue(x);
        System.out.println("x:" + x);

        int[] br = {10, 20, 30};
        MethodClass.callByReference(br);
        // 배열을 메서드에게 넘기면 배열의 내용이 변경될 수도 있음
        // 메서드의 리턴이 없는 경우라면 print 메서드를 제외하고는
        // 원본을 변경해주는 것임.
        System.out.println("br[0]:"+br[0]);

        MethodClass o1 = new MethodClass();
        o1.thisMethod();

        int noRecursionFibonacci = MethodClass.noRecursionFibonacci(2);
        System.out.println("noRecursionFibonacci = " + noRecursionFibonacci);

//        int recursionFibonacci = MethodClass.recursionFibonacci(2);
//        System.out.println("recursionFibonacci = " + recursionFibonacci);

        // display 메서드의 매개변수가 String ...args 이므로
        // 문자열을 몇 개 주어도 상관없음.
        MethodClass.display("굴리트");
        MethodClass.display("호날두", "메시");
        MethodClass.display("음바페", "살라", "덕배");
    }
}
