package nestedclass;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // 외부 클래스의 인스턴스를 생성
        InstanceInner instanceInner = new InstanceInner();
        // 내부 클래스의 인스턴스 생성 - Instance Inner 인 경우
//        InstanceInner.Inner inner = instanceInner.new Inner();

        // Static Inner Class 의 인스턴스 생성
        InstanceInner.Inner obj = new InstanceInner.Inner();

        //인스턴스 생성
        //인터페이스나 추상 클래스 등을 상속해서 클래스를 만들고
        //인스턴스를 만드는 경우
        //변수는 대부분 인터페이스 나 추상 클래스 이름으로 만들고
        //생성자는 사용하고자 하는 클래스의 생성자를 이용하는 경우가 많음
        //상위 클래스 나 인터페이스로 만들어진 변수에
        //하위 클래스의 인스턴스 참조를 대입할 수 있음
        //이렇게 만들어진 변수는 상위 클래스나 인터페이스에
        //존재하는 이름만 호출이 가능
        //실제 호출되는 것은 생성자를 따라 감.
        SampleAble instance = new SampleAbleImpl();
        // 메서드 호출
        instance.method();

        // Anonymous Class 사용
        SampleAble anonymous = new SampleAble() {
            @Override
            public void method() {
                System.out.println("Anonymous 이용");
            }
        };

        anonymous.method();

        // 메서드를 1번만 호출할 거라면 변수를 생성하지 않고 가능
        new SampleAble() {

            @Override
            public void method() {
                System.out.println("변수도 안만들고 anonymous 사용");
            }
        }.method();

        //public 클래스에 public static 속성은 어느 곳에서나
        //호출 가능
        GlobalData.global = 10;

//        Singleton singleton1 = new Singleton();
//        Singleton singleton2 = new Singleton();

        Singleton singleton1 = Singleton.sharedInstance();
        Singleton singleton2 = Singleton.sharedInstance();
        //해시코드 확인
        System.out.println(System.identityHashCode(singleton1));
        System.out.println(System.identityHashCode(singleton2));

        Table row1 = new Table();
        System.out.println(row1.getNum());
        Table row2 = new Table();
        System.out.println(row2.getNum());
        Table.setStep(10);
        Table row3 = new Table();
        System.out.println(row3.getNum());
    }
}
