package org.example;

public class GoodMain {
    public static void main(String[] args) {
        GoodDAO dao = GoodDAOImpl.getInstance();
        // 전체 데이터 가져오기
//        System.out.println(dao.getAll());

        // 기본키를 가지고 조회하면 존재하는 경우는 데이터가 리턴되고
        // 없는 경우에는 null이 리턴됨.
//        System.out.println(dao.getGood("1"));
//        System.out.println(dao.getGood("20"));
/*
        Good good = new Good();
        good.setCode("11");
        good.setName("주스");
        good.setManufacture("일본");
        good.setPrice(30);

        int r = dao.insertGood(good);
        if (r == 1) {
            System.out.println("삽입 성공");
        } else {
            System.out.println("삽입 실패");
        }*/

        // '한' 이 들어간 모든 것들을 출력해줌.
        System.out.println(dao.likeGood("한"));
        // like를 통해 글을 찾지 못했다면 빈배열이 출력됨
        System.out.println(dao.likeGood("뷁"));

    }
}
