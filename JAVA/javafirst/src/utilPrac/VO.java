package utilPrac;

// 크기 비교가 가능한 메서드가 있다는 것을 보장
public class VO implements Comparable<VO>{
    private int num;
    private String name;
    private int age;

    public VO() {
    }

    public VO(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "VO{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 크기 비교하는 메서드

    /**
     *
     * @param o 비교가 되는 파라미터
     * @return 양수일 경우 순서가 변경되고, 0이나 음수면 순서 변경이 안됨.
     */
    @Override
    public int compareTo(VO o) {
        // 숫자는 뺄셈을 해서 리턴하면 됨
        // 순서를 변경하면 내림차순이 됨.
//        return this.age - o.age;

        //문자열은 뺄셈이 안됨
        //문자열은 Comparable 인터페이스를 implements 했기 때문에
        //compareTo 메서드로 비교하면 됨.
        return this.name.compareTo(o.name);
    }
}
