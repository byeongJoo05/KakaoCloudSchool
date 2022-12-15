package OOP;

public class Student {
    public static String schoolName;

    //static 초기화
    static {
        System.out.println("로고 출력");
        schoolName = "환일고등학교";
//        num = 1; 스태틱 필드변수가 아닌건 불가능
    }

    // 인스턴스 속성 생성
    // 접근 지정자가 public 이므로 외부에서 인스턴스를 통해서 접근
    protected int num;
    public String name;
    public int kor;
    public int eng;
    public int mat;
}