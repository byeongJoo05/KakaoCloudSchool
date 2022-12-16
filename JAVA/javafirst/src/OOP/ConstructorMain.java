package OOP;

import java.util.Date;

public class ConstructorMain {
    public static void main(String[] args) {
        //인스턴스 생성
        Member member = new Member();
        member.setEmail("itoriginal@kmail.com");
        member.setPassword("1234");
        member.setMarried(true);
        member.setAge(29);
        String [] nicknames = {"카카오","네이버"};
        //오늘날짜
//        member.setBirthday(new Date());
        //1970.06.29
        member.setBirthday(new Date(70, 5, 29));
        member.setNicknames(nicknames);

        System.out.println(member);

        // 초기화 메서드 생성
        Member member1 = new Member();
        // 속성 초기화하는 메서드를 호출
        member1.init("thsqudwn05@gmail.com", "1234", nicknames, new Date(), false, 53);
        System.out.println(member1);

        //생성자를 이용한 초기화
        Member member2 = new Member("thsqudwn05@gmail.com", "1234", nicknames, new Date(), false, 53);
        System.out.println("member2 = " + member2);
    }
}
