package langPrac;

import java.util.Arrays;
import java.util.Objects;

// 하나의 데이터 묶음을 표현하기 위한 클래스 - Value Object (VO)
public class Data implements Cloneable{
    private int num;
    private String name;
    private String [] nicknames;

    // 빈 생성자(Default Constructor)
    public Data() {
    }

    // 속성을 대입받아서 생성하는 생성자
    // 인스턴스를 빠르게 초기화 하기 위해서 사용
    public Data(int num, String name, String[] nicknames) {
        this.num = num;
        this.name = name;
        this.nicknames = nicknames;
    }

    // 접근자 메서드
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getNicknames() {
        return nicknames;
    }

    public void setNicknames(String[] nicknames) {
        this.nicknames = nicknames;
    }

    // 인스턴스의 내용을 빠르게 만들기 위해 사용
    // 디버깅을 위한 메서드
    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nicknames=" + Arrays.toString(nicknames) +
                '}';
    }

    // 복제를 위한 메서드
    public Data clone() {
        Data data = new Data();
        // 이 방식은 얕은 복사 (weak copy)
        // num은 숫자 데이터이므로 바로 복제가 가능
        // name 와 nicknames 는 숫자 데이터가 아님
        // 바로 대입하면 참조가 대입됨.
        data.setNum(this.num);
        data.setName(this.name);
//        data.setNicknames(this.nicknames);

        // 배열을 복제한 후 대입 - 깊은 복사
        String[] nicknames = Arrays.copyOf(this.nicknames, this.nicknames.length);
        data.setNicknames(nicknames);
        return data;
    }

    // 데이터의 내용이 같은지 확인하는 메서드
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        // 원래 자료형으로 변환
        Data obj1 = (Data) obj;
        // 숫자나 boolean은 == 로 일치여부를 판단하지만
        // 그 이외의 자료형은 equals 로 판단
        if (this.num == obj1.getNum() && this.name == obj1.getName()) {
            return true;
        }

        // Objects.hash (데이터 나열)을 이용하면
        // 데이터를 가지고 정수로 만든 해시코드를 생성
        // 이렇게 만든 해시 코드 값을 리턴하는 것이 속도가 더 빠름
        return Objects.hash(num, name) == Objects.hash(
                obj1.getNum(), obj1.getName());
    }
}
