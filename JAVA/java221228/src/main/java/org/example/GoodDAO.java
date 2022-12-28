package org.example;

import java.util.List;

// goods 테이블에 수행할 데이터베이스 작업의 원형을 소유할 인터페이스
public interface GoodDAO {
    // goods 테이블의 전체 데이터 가져오기
    public List<Good> getAll();

    // goods 테이블에서 name 이나 manufacture에 포함된 데이터 조회
    public List<Good> likeGood(String content);

    // goods 테이블에 데이터를 삽입하기
    // 수정은 모양이 동일
    // 삭제는 동일하게 만들어도 되고 매개변수를 기본키로 만들어도 됨.
    public int insertGood(Good good);
}
